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
import com.misys.gameofcodes.model.Badge;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

	
public class BadgeDAOImpl implements BadgeDAO {
	private CollectionProvider collectionProvider;
	private DBCollection badgesCollection;
	public BadgeDAOImpl ()
	{
		collectionProvider = new CollectionProvider();
		badgesCollection = collectionProvider.getCollection("Badge");
	}
	@Override
	public List<Badge> getAllBadges() {
		DBCursor cursor = badgesCollection.find();
		List<Badge> badges = new ArrayList<Badge>();
        while(cursor.hasNext()){
        	DBObject dbBadges = cursor.next();
        	Badge badge = getBadge(dbBadges);
        	badges.add(badge);
        }
		return badges;
	}
	
	@Override
	public Badge getBadge(Badge badge) {
	    BasicDBObject query = new BasicDBObject();
	    if(badge.getId() != null) {
	    	query.put("_id", new ObjectId(badge.getId()));
	    }
	    if(badge.getBadgeName() != null && badge.getBadgeType() != null) {
	    	query.put("badgeName", badge.getBadgeName());
	    	query.put("badgeType", badge.getBadgeType());
	    }
	    DBObject dbBadge = badgesCollection.findOne(query);
	    return getBadge(dbBadge);
	}
	@Override
	public Badge getBadge(DBObject dbBadge) {
		Badge badge = new Badge();
    	ObjectId badgeObjId = (ObjectId) dbBadge.get("_id");
    	badge.setId(badgeObjId.toString());
    	badge.setBadgeName(dbBadge.get("badgeName").toString());
    	badge.setDescription(dbBadge.get("description").toString());
    	badge.setBadgeType(dbBadge.get("badgeType").toString());
    	badge.setImageId(dbBadge.get("imageId").toString());
    	return badge;
	}

	@Override
	public WriteResult addBadge(Badge badge) {
		BasicDBObject badgeObject = new BasicDBObject("badgeName", badge.getBadgeName())
      		  .append("description", badge.getDescription())
			  .append("badgeType", badge.getBadgeType())
			  .append("imageId", badge.getImageId());
		return badgesCollection.insert(badgeObject);
	}
	
	/**
	 * update badge name
	 * @param Badge with object id value and new name
	 * @return WriteResult default output for mongodb requests
	 */
	@Override
	public WriteResult updateBadge(Badge badge) {
		Badge updateBadge = getBadge(badge);
	    BasicDBObject query = new BasicDBObject();
	    query.put("badgeName", updateBadge.getBadgeName());
	  //  query.put("_id", new ObjectId(updateBadge.getId()));
	    DBObject dbBadge = badgesCollection.findOne(query);
	    	dbBadge.put("description",badge.getDescription());
	    	return badgesCollection.update(query, dbBadge); 
	}

	/**
	 * delete here using username or id
	 * @param Badge with username value
	 * @return WriteResult default output for mongdb requests
	 */
	@Override
	public WriteResult deleteBadge(Badge badge) {
		BasicDBObject query = new BasicDBObject();
	    if(badge.getId() != null) {
	    	query.put("_id", new ObjectId(badge.getId()));
	    }
	    if(badge.getBadgeName() != null) {
	    	query.put("badgeName", badge.getBadgeName());
	    }
		return badgesCollection.remove(query);
		  
	}

}

