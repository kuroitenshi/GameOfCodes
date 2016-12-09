package com.misys.gameofcodes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.Level;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class LevelDAOImpl implements LevelDAO {
	private CollectionProvider collectionProvider;
	private DBCollection levelsCollection;
	public LevelDAOImpl ()
	{
		collectionProvider = new CollectionProvider();
		levelsCollection = collectionProvider.getCollection("Level");
	}
	@Override
	public List<Level> getAllHeroLevels() {
	    BasicDBObject query = new BasicDBObject();
	    	query.put("type", "hero");
		DBCursor cursor = levelsCollection.find(query);
		List<Level> levels = new ArrayList<Level>();
        while(cursor.hasNext()){
        	DBObject dbLevels = cursor.next();
        	Level level = getLevel(dbLevels);
        	levels.add(level);
        }
		return levels;
	}

	@Override
	public List<Level> getAllHouseLevels() {
		BasicDBObject query = new BasicDBObject();
	  	query.put("type", "hero");
		DBCursor cursor = levelsCollection.find(query);
		List<Level> levels = new ArrayList<Level>();
	    while(cursor.hasNext()){
	    	DBObject dbLevels = cursor.next();
	    	Level level = getLevel(dbLevels);
	    	levels.add(level);
	    }
	    return levels;
	}
	@Override
	public Level getLevel(Level level) {
	    BasicDBObject query = new BasicDBObject();
	    if(level.getId() != null) {
	    	query.put("_id", new ObjectId(level.getId()));
	    }
	    if(level.getLevel() != 0 && level.getType() != null) {
	    	query.put("level", level.getLevel());
	    	query.put("type", level.getType());
	    }
	    DBObject dbLevel = levelsCollection.findOne(query);
	    return getLevel(dbLevel);
	}
	@Override
	public Level getLevel(DBObject dbLevel) {
		Level level = new Level();
    	ObjectId levelObjId = (ObjectId) dbLevel.get("_id");
    	level.setId(levelObjId.toString());
    	level.setType(dbLevel.get("type").toString());
    	level.setName(dbLevel.get("name").toString());
    	level.setLevel((int) dbLevel.get("level"));
    	level.setPoints((int) dbLevel.get("storyPoints"));
    	level.setDescription(dbLevel.get("description").toString());
    	level.setIcon(dbLevel.get("icon").toString());
    	return level;
	}
	@Override
	public Level getHeroLevel(int points) {
	    BasicDBObject query = new BasicDBObject();
	    	query.put("storyPoints", new BasicDBObject("$lte", points));
	    	query.put("type", "hero");
	    DBCursor cursor = levelsCollection.find(query).sort(new BasicDBObject("level",-1)).limit(1);
	    DBObject dbLevel = cursor.next();
	    return getLevel(dbLevel);
	}
	@Override
	public WriteResult addHeroLevel(Level level) {
		BasicDBObject levelObject = new BasicDBObject("type", "hero")
				  .append("name", level.getName())
	      		  .append("level", level.getLevel())
				  .append("storyPoints", level.getPoints())
				  .append("description", level.getDescription())
				  .append("icon", level.getIcon());
			return levelsCollection.insert(levelObject);
	}

	@Override
	public WriteResult addHouseLevel(Level level) {
		BasicDBObject levelObject = new BasicDBObject("type", "house")
				  .append("name", level.getName())
	      		  .append("level", level.getLevel())
				  .append("storyPoints", level.getPoints())
				  .append("description", level.getDescription())
				  .append("icon", level.getIcon());
			return levelsCollection.insert(levelObject);
	}
	@Override
	public WriteResult updateLevel(Level level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WriteResult deleteLevel(Level level) {
		// TODO Auto-generated method stub
		return null;
	}



}
