package com.navelplace.ben.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;

import com.navelplace.ben.entities.Company;
import com.navelplace.ben.entities.Document;

public class DocumentDao extends BaseDao<Document>
{
	
	public DocumentDao(Datastore datastore)
	{
		super(datastore, Document.class);
	}
		
	@Override
	public void beforeDelete(Document document) {
		List<Document> documents = document.getCompany().getDocuments();
		if (documents.contains(documents)) {
			documents.remove(document);
			UpdateOperations<Company> operations = datastore.createUpdateOperations(Company.class).set("documents", documents);
			datastore.update(document.getCompany(), operations);
		}
	}

}

