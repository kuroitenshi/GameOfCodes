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
	public List<Hero> getAllHeroes() {   
		DBCursor cursor = heroesCollection.find();
        List<Hero> heroes = new ArrayList<Hero>();
        while(cursor.hasNext()){
        	DBObject dbhero = cursor.next();
        	System.out.println(dbhero.toString());
        	Hero hero = getHero(dbhero);
    		heroes.add(hero);
        }
		return heroes;
	}
	public Hero getHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    return getHero(dbHero);
	}
	public Hero getHero(DBObject dbhero) {
		Hero hero = new Hero();
    	ObjectId objId = (ObjectId) dbhero.get("_id");
    	hero.setId(objId.toString());
    	hero.setUsername(dbhero.get("username").toString());
    	hero.setName(dbhero.get("name").toString());
    	hero.setEmail(dbhero.get("email").toString());
    	hero.setStoryPoints(Integer.parseInt(dbhero.get("story_points").toString()));
    	hero.setIsActive(dbhero.get("is_active").toString());
		
    	return hero;
	}
	public WriteResult addHero(Hero hero) {
		BasicDBObject heroObject = new BasicDBObject("username", hero.getUsername())
			  .append("name", hero.getName())
      		  .append("email", hero.getEmail())
			  .append("story_points", 0)
			  .append("is_active", 'Y');
		return heroesCollection.insert(heroObject);
	}
	public WriteResult updateHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("name",hero.getName());
	    	return heroesCollection.update(query, dbHero); 
	}
	public WriteResult deleteHero(Hero hero) {
		BasicDBObject query = new BasicDBObject("username", hero.getUsername());
		return heroesCollection.remove(query);
		  
	}
	public WriteResult setActiveHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("isActive","Y");
	    	return heroesCollection.update(query, dbHero); 
	}
	public WriteResult setInactiveHero(Hero hero) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", new ObjectId(hero.getId()));
	    DBObject dbHero = heroesCollection.findOne(query);
	    	dbHero.put("isActive","N");
	    	return heroesCollection.update(query, dbHero); 
	}
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

