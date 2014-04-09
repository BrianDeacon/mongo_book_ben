package com.navelplace.ben.entities;

import java.util.UUID;

import org.mongodb.morphia.annotations.Id;

public class BaseEntity
{
	@Id
	private String id = UUID.randomUUID().toString();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	
}

