package com.navelplace.ben.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * Document
 * - docId
 * - description
 * - filed by exactly one company
 */
@Entity("documents")
public class Document extends BaseEntity
{
	private String description;
	
	@Reference
	private Company company;
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Company getCompany()
	{
		return company;
	}
	public void setCompany(Company company)
	{
		this.company = company;
	}
	
	
}

