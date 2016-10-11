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

	@Override
	public House getHouse(House house) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(house.getId()));
	    DBObject dbHouse = houseCollection.findOne(query);
	    return getHouse(dbHouse);
	}

	public House getHouse(DBObject dbHouse) {
		House house = new House();
    	ObjectId objId = (ObjectId) dbHouse.get("_id");
    	house.setId(objId.toString());
    	house.setHousename(dbHouse.get("housename").toString());
    	house.setDomain(dbHouse.get("domain").toString());
    	house.setBanner(dbHouse.get("banner").toString());
    	return house;
	}
	@Override
	public WriteResult addHouse(House house) {
		BasicDBObject houseObject = new BasicDBObject("housename", house.getHousename())
				.append("domain", house.getDomain())  
				.append("banner", house.getBanner());
		return houseCollection.insert(houseObject);
	}

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

	@Override
	public WriteResult deleteHouse(House house) {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(house.getId()));
		return houseCollection.remove(query);
	}

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




}

