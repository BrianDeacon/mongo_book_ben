package com.navelplace.ben;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.navelplace.ben.entities.Company;

public class MongoFactory
{
	private static final Logger logger = LoggerFactory.getLogger(MongoFactory.class);
	public static final String DB_NAME = "ben";
	private static boolean closed = false;
	
	private MongoFactory() {}
	
	
	private static class SingletonHolder {
		private static MongoClient mongoClient;
		private static Morphia morphia;
		private static Datastore datastore;
		
		
		static {
			try
			{
				mongoClient = new MongoClient();
				morphia = new Morphia();
				datastore = morphia.createDatastore(mongoClient, DB_NAME);
				morphia.mapPackage(Company.class.getPackage().getName());
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(), e);
				throw new RuntimeException(e);
			}
			
		}
	
		public static Datastore getDatastore() {
			if (closed)
			{
				throw new RuntimeException("Datastore has been closed.");
			}
			return datastore;
		}
		
		public static MongoClient getMongoClient() {
			return mongoClient;
		}
    	
    	
	}
	
	public static Datastore getDatastoreInstance() {
		return SingletonHolder.getDatastore();
	}
	
	public static void close() {
		closed = true;
		SingletonHolder.getMongoClient().close();
	}
}

