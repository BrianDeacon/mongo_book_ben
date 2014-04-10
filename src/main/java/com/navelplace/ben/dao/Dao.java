package com.navelplace.ben.dao;


public interface Dao<EntityType>
{
	void save(EntityType entity);
	EntityType findById(String id);
	void deleteById(String id);
	void delete(EntityType entity);
	void beforeDelete(EntityType entity);
	void afterSave(EntityType entity);
}

