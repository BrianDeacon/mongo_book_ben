package com.navelplace.ben.dao;

import org.apache.commons.collections.CollectionUtils;
import org.mongodb.morphia.Datastore;

import com.navelplace.ben.entities.Company;
import com.navelplace.ben.entities.Document;

public class CompanyDao extends BaseDao<Company>
{
	private DocumentDao documentDao;
	
	public CompanyDao(Datastore datastore)
	{
		super(datastore, Company.class);
	}
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	
	@Override
	public void afterSave(Company company) {
		if (CollectionUtils.isNotEmpty(company.getDocuments())) {
			for (Document document : company.getDocuments()) {
				documentDao.save(document);
			}
		}
	}
	
	@Override
	public void beforeDelete(Company company) {
		if (CollectionUtils.isNotEmpty(company.getDocuments())) {
			for (Document document : company.getDocuments()) {
				documentDao.delete(document);
			}
		}
	}
	
	
}

