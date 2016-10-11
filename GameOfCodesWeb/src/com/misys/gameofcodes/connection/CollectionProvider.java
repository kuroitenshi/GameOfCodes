package com.misys.gameofcodes.connection;

import com.misys.gameofcodes.connection.concreteFactories.MongoDBConnectionFactory;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class CollectionProvider 
{ 
	private MongoDBConnectionFactory mongoDbConnectionFactory;
	private DB gameOfCodesDB;
	
	/**
	 * Initializes MongoDb Connections and initial collection
	 */
	public CollectionProvider()
	{
		mongoDbConnectionFactory = new MongoDBConnectionFactory();
		mongoDbConnectionFactory.createDatabaseConnection();
		gameOfCodesDB = mongoDbConnectionFactory.getGameOfCodesDB();
	}
	
	/**
	 * Returns collection of heroes
	 * @return hero collection
	 */
	public DBCollection getCollection(String collectionName) 
	{
        DBCollection dbCollection = gameOfCodesDB.getCollection(collectionName);
        System.out.println("Collection mycol selected successfully");
		return dbCollection;
	}
}
