package com.misys.gameofcodes.connection.concreteFactories;

import com.misys.gameofcodes.connection.abstractFactory.AbstractConnectionFactory;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBConnectionFactory extends AbstractConnectionFactory
{
	private MongoClient mongoDBConnection;

	/* 
	 * Inherited from abstract connection Factory
	 * Connection implementation varies depending of the database type
	 * 
	 */
	@Override
	public void createDatabaseConnection() {
		
		MongoClient mongoClient = null;
		String mongoIpAddress = "mancswfbedv0004";
		int mongoPort = 27017;
		
		if(mongoClient == null)
		{
	       	mongoClient = new MongoClient( mongoIpAddress, mongoPort);
	    }
		 mongoDBConnection = mongoClient;
	}
	
	/**
	 * Initializes collection for the DB of Game of Codes
	 * @return DB Object for Game of Codes
	 */
	public DB getGameOfCodesDB ()
	{
		DB db = this.mongoDBConnection.getDB( "GameOfCodes" );
	    DBObject options = null;
	    db.createCollection("heroes", options);
	    db.createCollection("houses", options);
	    db.createCollection("adventures", options);
	    db.createCollection("quests", options);
	    db.createCollection("badges", options);
	    db.createCollection("items", options);
	    System.out.println("Connect to database successfully");
	    
	    return db;

	}     

}
