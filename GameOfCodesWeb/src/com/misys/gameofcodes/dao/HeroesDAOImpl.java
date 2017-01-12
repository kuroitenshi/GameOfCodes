package com.misys.gameofcodes.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class HeroesDAOImpl implements HeroesDAO {
	private CollectionProvider collectionProvider;
	private DBCollection heroesCollection;
	public HeroesDAOImpl ()
	{
		collectionProvider = new CollectionProvider();
		heroesCollection = collectionProvider.getCollection("Hero");
	}
	/** 
	 * Get all heroes
	 */
	@Override
	public List<Hero> getAllHeroes() {   
		DBCursor cursor = heroesCollection.find();
        List<Hero> heroes = new ArrayList<Hero>();
        while(cursor.hasNext()){
        	DBObject dbhero = cursor.next();
        	Hero hero = getHero(dbhero);
    		heroes.add(hero);
        }
		return heroes;
	}
	/** 
	 * Get hero with either object id or username
	 * @param Hero with object id or username
	 * @returns Hero with complete details from database
	 */
	@Override
	public Hero getHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    if(hero.getId() != null) {
	    	query.put("_id", new ObjectId(hero.getId()));
	    }
	    if(hero.getUsername() != null) {
	    	query.put("username", hero.getUsername());
	    }
	    DBObject dbHero = heroesCollection.findOne(query);
	    return getHero(dbHero);
	}
	/** 
	 * Remaps hero object from db to model Hero
	 * @param DBObject hero object from database
	 * @returns Hero with complete details from database
	 */
	@Override
	public Hero getHero(DBObject dbhero) {
		Hero hero = new Hero();
    	ObjectId heroObjId = (ObjectId) dbhero.get("_id");
    	hero.setId(heroObjId.toString());
    	hero.setUsername(dbhero.get("username").toString());
    	hero.setName(dbhero.get("name").toString());
    	hero.setEmail(dbhero.get("email").toString());
    	hero.setStoryPoints((int) dbhero.get("storyPoints"));
    	hero.setLevel((String) dbhero.get("level"));
    	hero.setIsActive(dbhero.get("isActive").toString());
//    	hero.setIsGameMaster(dbhero.get("isGameMaster").toString());
//    	hero.setEquipmentHead1(dbhero.get("equipmentHead1").toString());
//    	hero.setEquipmentHead2(dbhero.get("equipmentHead2").toString());
//    	hero.setEquipmentHead3(dbhero.get("equipmentHead3").toString());
//    	hero.setEquipmentUpperBody(dbhero.get("equipmentUpperBody").toString());
//    	hero.setEquipmentLowerBody(dbhero.get("equipmentLowerBody").toString());
//    	hero.setEquipmentBoots(dbhero.get("equipmentBoots").toString());
//    	hero.setEquipmentRightHand(dbhero.get("equipmentRightHand").toString());
//    	hero.setEquipmentLeftHand(dbhero.get("equipmentLeftHand").toString());
//    	hero.setEquipmentWings(dbhero.get("equipmentWings").toString());;
//    	House house = new House();
//    	BasicDBObject dbHouse = (BasicDBObject) dbhero.get("house"); 
//    	ObjectId houseObjId = (ObjectId) dbHouse.get("_id");
//    	house.setId(houseObjId.toString());
//		hero.setHouse(HouseService.fetchHouse(house));
    	return hero;
	}
	/** 
	 * Adds new hero to database with values for username, name and email
	 * and defaults isActive and storyPoints
	 * @param Hero
	 * @returns WriteResult default output for mongodb requests
	 */
	@Override
	public WriteResult addHero(Hero hero) {
		BasicDBObject heroObject = new BasicDBObject("username", hero.getUsername())
			  .append("name", hero.getName())
      		  .append("email", hero.getEmail())
			  .append("storyPoints", 0)
			  .append("level", 1)
			  .append("isActive", 'Y');
		return heroesCollection.insert(heroObject);
	}
	/**
	 * update hero name
	 * @param Hero with object id value and new name
	 * @return WriteResult default output for mongodb requests
	 */
	@Override
	public WriteResult updateHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("name",hero.getName());
	    	return heroesCollection.update(query, dbHero); 
	}
	/**
	 * update hero points and level
	 * @param Hero with object id value and new name
	 * @return WriteResult default output for mongodb requests
	 */
	@Override
	public WriteResult updateHeroPoints(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("storyPoints",hero.getStoryPoints());
	    	dbHero.put("level",hero.getLevel());
	    return heroesCollection.update(query, dbHero); 
	}
	/**
	 * delete here using username or id
	 * @param Hero with username value
	 * @return WriteResult default output for mongdb requests
	 */
	@Override
	public WriteResult deleteHero(Hero hero) {
		BasicDBObject query = new BasicDBObject();
	    if(hero.getId() != null) {
	    	query.put("_id", new ObjectId(hero.getId()));
	    }
	    if(hero.getUsername() != null) {
	    	query.put("username", hero.getUsername());
	    }
		return heroesCollection.remove(query);
		  
	}
	/**
	 * sets hero active
	 * @param Hero
	 * @return WriteResult default output for mongodb
	 */
	@Override
	public WriteResult setActiveHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("isActive","Y");
	    	return heroesCollection.update(query, dbHero); 
	}
	/**
	 * sets hero as inactive
	 * @param Hero
	 * @return WriteResult default output for mongodb
	 */
	@Override
	public WriteResult setInactiveHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("isActive","N");
	    	return heroesCollection.update(query, dbHero); 
	}
	/**
	 * changes the assigned house of a hero
	 * @param Hero, House 
	 * @param WriteResult default output for mongodb
	 */
	@Override
	public WriteResult updateHeroHouse(Hero hero, House house) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
		BasicDBObject houseObject = new BasicDBObject("_id",new ObjectId(house.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    dbHero.put("house", houseObject);
		return heroesCollection.update(query, dbHero);
	}
}

