package com.navelplace.ben.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.CriteriaContainer;
import org.mongodb.morphia.query.CriteriaContainerImpl;
import org.mongodb.morphia.query.Query;

import com.navelplace.ben.entities.Company;
import com.navelplace.ben.entities.User;

public class UserDao extends BaseDao<User>
{
	private CompanyDao companyDao;
	
	public UserDao(Datastore datastore) {
		super(datastore, User.class);
	}

	public void setCompanyDao(CompanyDao companyDao)
	{
		this.companyDao = companyDao;
	}
	
	@Override
	public void afterSave(User user) {
		if (CollectionUtils.isNotEmpty(user.getCompanies())) {
			for (Company company : user.getCompanies()) {
				companyDao.save(company);
			}
		}
	}
	
	public List<User> findUsersWithCompany(Company company) {
		if (company == null) {
			return new ArrayList<>();
		}
		Query<User> query = datastore.createQuery(User.class).field("companies").hasThisElement(company);
		return query.asList();
		
	}
	
	public void findUsersWithCompany(String companyId) {
		findUsersWithCompany(companyDao.findById(companyId));
	}
	
}

