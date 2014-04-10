package com.navelplace.ben.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import com.navelplace.ben.exception.InvalidIdException;

/**
 * Covers the basic CRUD operations on the assumption that everything should
 * cascade.
 */
public abstract class BaseDao<EntityType> implements Dao<EntityType>
{
	protected Datastore datastore;
	protected Class<EntityType> entityType;

	protected BaseDao(Datastore datastore, Class<EntityType> entityType) {
		this.entityType = entityType;
		this.datastore = datastore;
	}
	
	@Override
	public EntityType findById(String id) {
		if (!ObjectId.isValid(id)) {
	        throw new InvalidIdException(id, getClass());
	    }
	    ObjectId objectId = new ObjectId(id);
		return (EntityType) datastore.find(entityType).field("_id").equal(objectId).get();
	}
	
	@Override
	public void deleteById(String id) {
		delete(findById(id));
	}
	
	@Override
	public void delete(EntityType entity) {
		if (entity != null) {
			beforeDelete(entity);
			datastore.delete(entity);
		}
	}
	
	@Override
	public void save(EntityType entity) {
		datastore.save(entity);
		afterSave(entity);
	}
	
	/**
	 * Each specific DAO can handle cascading the deletes by overriding this method
	 */ 
	@Override 
	public void beforeDelete(EntityType entity) {}
	
	/**
	 * Handle cascading updates by overriding this method
	 */ 
	@Override
	public void afterSave(EntityType entity) {}
}

