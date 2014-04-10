package com.navelplace.ben.entities;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * Company
 *  - stateId
 *  - name
 *  - zero or more historical documents 
 */ 
@Entity("companies")
public class Company extends BaseEntity
{
	private String name;
	private String stateId;
	
	@Reference
	private List<Document> documents = new ArrayList<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Document> getDocuments()
	{
		return documents;
	}

	public void setDocuments(List<Document> documents)
	{
		this.documents = documents;
	}

	public String getStateId()
	{
		return stateId;
	}

	public void setStateId(String stateId)
	{
		this.stateId = stateId;
	}
	
	
	
	
}

