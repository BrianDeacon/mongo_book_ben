package com.navelplace.ben.entities;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * User: 
 *  - userId
 *  - zero or more favorite companies 
 */
@Entity("users")
public class User extends BaseEntity
{
	
	@Reference
    private List<Company> companies = new ArrayList<>();

	public List<Company> getCompanies()
	{
		return companies;
	}

	public void setCompanies(List<Company> companies)
	{
		this.companies = companies;
	}

}

