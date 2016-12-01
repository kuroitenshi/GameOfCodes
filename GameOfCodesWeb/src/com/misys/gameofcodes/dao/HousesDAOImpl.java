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
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class HousesDAOImpl implements HousesDAO {

	private CollectionProvider collectionProvider;
	private DBCollection houseCollection;
	public HousesDAOImpl() 
	{
		collectionProvider = new CollectionProvider();
		houseCollection = collectionProvider.getCollection("House");
	}
	/**
	 * Get all houses
	 */
	@Override
	public List<House> getAllHouses() {
        DBCursor cursor = houseCollection.find();
        List<House> houses= new ArrayList<House>();
        while(cursor.hasNext()){
        	DBObject dbHouse = cursor.next();
    		House house = getHouse(dbHouse);
    		houses.add(house);
        }
		return houses;
	}
	/**
	 * get a specific house by object id, house name or domain name
	 * @param House
	 * @return House with details from db
	 */
	@Override
	public House getHouse(House house) {
	    BasicDBObject query = new BasicDBObject();
	    if (house.getId() != null) {
	    	query.put("_id", new ObjectId(house.getId()));
	    }
	    if (house.getHousename() != null) {
	    	query.put("housename", new ObjectId(house.getHousename()));
	    }
	    if (house.getDomain() != null) {
	    	query.put("domain", new ObjectId(house.getDomain()));
	    }
	    DBObject dbHouse = houseCollection.findOne(query);
	    return getHouse(dbHouse);
	}
	/**
	 * remap house from db to house model
	 * @param DBObject object from db
	 * @return House
	 */
	@Override
	public House getHouse(DBObject dbHouse) {
		House house = new House();
    	ObjectId objId = (ObjectId) dbHouse.get("_id");
    	house.setId(objId.toString());
    	house.setHousename(dbHouse.get("housename").toString());
    	house.setDomain(dbHouse.get("domain").toString());
    	house.setBanner(dbHouse.get("banner").toString());
    	house.setStoryPoints(dbHouse.get("storyPoints").toString());
    	house.setLevel(dbHouse.get("level").toString());
    	house.setIsActive(dbHouse.get("isActive").toString());
    	return house;
	}
	/**
	 * create a new house
	 * @param House
	 * @return WriteResult
	 */
	@Override
	public WriteResult createHouse(House house) {
		BasicDBObject houseObject = new BasicDBObject("housename", house.getHousename())
				.append("domain", house.getDomain())  
				.append("banner", house.getBanner())
				.append("storyPoints", 0)
				.append("level", 1)
				.append("isActive", "Y");
		return houseCollection.insert(houseObject);
	}
	/**
	 * update house housename, banner and domain
	 * @param House
	 * @return WriteResult
	 */
	@Override
	public WriteResult updateHouse(House house) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(house.getId()));
	    DBObject dbHouse = houseCollection.findOne(query);
	    	dbHouse.put("housename",house.getHousename());
	    	dbHouse.put("banner",house.getBanner());
	    	dbHouse.put("domain",house.getDomain());
	    return houseCollection.update(query, dbHouse); 
		
	}
	/**
	 * update house story points and level
	 * @param House
	 * @return WriteResult
	 */
	@Override
	public WriteResult updateHousePoints(House house) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(house.getId()));
	    DBObject dbHouse = houseCollection.findOne(query);
	    	dbHouse.put("storyPoints",house.getStoryPoints());
	    	dbHouse.put("level",house.getLevel());
	    return houseCollection.update(query, dbHouse); 
		
	}
	/**
	 * deletes a house by object id
	 * @param id
	 * @return WriteResult
	 */
	@Override
	public WriteResult deleteHouse(String id) {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		return houseCollection.remove(query);
	}
	/**
	 * deletes a house by object id
	 * @param house
	 * @return WriteResult
	 */
	@Override
	public WriteResult deleteHouse(House house) {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(house.getId()));
		return houseCollection.remove(query);
	}
	/**
	 * add a hero to the house
	 * @param House Hero
	 * @ return WriteResult
	 */
	@Override
	public WriteResult addHouseHero(House house, Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(house.getId()));
		BasicDBObject heroesObject = new BasicDBObject("_id",new ObjectId(hero.getId()));	    
	    DBObject dbHouse = houseCollection.findOne(query);
	    	List<BasicDBObject> heroesList = (List<BasicDBObject>) dbHouse.get("heroes");
	    	heroesList.add(heroesObject);
	    dbHouse.put("heroes", heroesList);
		return houseCollection.update(query, dbHouse);
	}
	/**
	 * remove a hero from the house
	 * @param House Hero
	 * @ return WriteResult
	 */
	@Override
	public WriteResult removeHouseHero(House house, Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(house.getId()));
		BasicDBObject heroesObject = new BasicDBObject("_id",new ObjectId(hero.getId()));	    
	    DBObject dbHouse = houseCollection.findOne(query);
	    	List<BasicDBObject> heroesList = (List<BasicDBObject>) dbHouse.get("heroes");
	    	heroesList.remove(heroesObject);
	    dbHouse.put("heroes", heroesList);
		return houseCollection.update(query, dbHouse);
	}
}

