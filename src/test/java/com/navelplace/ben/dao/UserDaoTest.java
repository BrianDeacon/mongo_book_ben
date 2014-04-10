package com.navelplace.ben.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.navelplace.ben.MongoFactory;
import com.navelplace.ben.entities.Company;
import com.navelplace.ben.entities.Document;
import com.navelplace.ben.entities.User;

public class UserDaoTest
{
	
	private UserDao userDao;
	private CompanyDao companyDao;
	private DocumentDao documentDao;
	private User user;
	
	@Before
	public void before() {
		userDao = new UserDao(MongoFactory.getDatastoreInstance());
		companyDao = new CompanyDao(MongoFactory.getDatastoreInstance());
		documentDao = new DocumentDao(MongoFactory.getDatastoreInstance());
		userDao.setCompanyDao(companyDao);
		companyDao.setDocumentDao(documentDao);
		user = makeUser();
		
	}
	
	@After
	public void after() {
		userDao.delete(user);
	}
	
	private String randomString(String prefix, int number) {
		return String.format("%s%d %s", prefix, number, UUID.randomUUID().toString());
	}
	
	private User makeUser() {
		User user = new User();
		for (int i = 0; i < 3; i++) {
			user.getCompanies().add(makeCompany(i));
		}
		return user;
	}
	
	private Company makeCompany(int i) {
		Company company = new Company();
		for (int j = 0; j < 3; j++) {
			company.getDocuments().add(makeDocument(j, company));
		}
		
		company.setName(randomString("Name", i));
		company.setStateId(randomString("State", i));
		return company;
	}

	private Document makeDocument(int i, Company company)
	{
		Document document = new Document();
		
		document.setCompany(company);
		document.setDescription(randomString("Description", i));
		
		return document;
	}
	
	@Test
	public void testSaveUser() {
		userDao.save(user);
		
		User savedUser = userDao.findById(user.getId().toString());
		assertEquals(savedUser, user);
		assertNotSame(savedUser, user);
	}
	
	@Test
	public void testDocumentCascades() {
		userDao.save(user);
		for (Company company : user.getCompanies()) {
			for (Document document : company.getDocuments()) {
				Document savedDocument = documentDao.findById(document.getId().toString());
				assertEquals(savedDocument, document);
				assertNotSame(savedDocument, document);
			}
		}
	}

	@Test
	public void testFindUsersWithCompany() {
		userDao.save(user);
		for (Company company : user.getCompanies()) {
			List<User> actual = userDao.findUsersWithCompany(company);
			assertEquals(1, actual.size());
			assertEquals(user, actual.get(0));
			assertNotSame(user, actual.get(0));
		}
	}

}

