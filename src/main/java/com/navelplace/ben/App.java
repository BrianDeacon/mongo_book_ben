package com.navelplace.ben;

import java.net.UnknownHostException;
import java.util.UUID;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.navelplace.ben.dao.CompanyDao;
import com.navelplace.ben.dao.DocumentDao;
import com.navelplace.ben.dao.UserDao;
import com.navelplace.ben.entities.Company;
import com.navelplace.ben.entities.Document;
import com.navelplace.ben.entities.User;

public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	
    public static void main( String[] args ) throws UnknownHostException
    { 
    }
    
 
}
