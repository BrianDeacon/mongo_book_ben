package com.navelplace.ben.entities;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public abstract class BaseEntity
{
	@Id
	private ObjectId id = new ObjectId();

	public ObjectId getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass().equals(getClass())) {
			BaseEntity other = (BaseEntity) obj;
			return id.equals(other.id);
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	
	
}

