package com.misys.gameofcodes.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.HouseService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class AdventureDAOImpl implements AdventureDAO {
	private CollectionProvider collectionProvider;
	private DBCollection adventuresCollection;
	public AdventureDAOImpl ()
	{
		collectionProvider = new CollectionProvider();
		adventuresCollection = collectionProvider.getCollection("Adventure");
	}
	
	/**
	 * Get all adventures
	 */
	public List<Adventure> getAllAdventures() {
		DBCursor cursor = adventuresCollection.find();
		List<Adventure> Adventures = new ArrayList<Adventure>();
		while(cursor.hasNext()){
			DBObject dbAdventure = cursor.next();
			Adventure Adventure = this.getAdventure(dbAdventure);
			Adventures.add(Adventure);
		}
		return Adventures;	
	}



	@Override
	public Adventure getAdventure(DBObject dbAventure) {
		Adventure adventure = new Adventure();
		ObjectId objId = (ObjectId) dbAventure.get("_id");
		adventure.setId(objId);
		adventure.setAdventurename(dbAventure.get("adventureName").toString());
		adventure.setDateEnd((Date) dbAventure.get("dateEnd"));
		adventure.setDateStart((Date) dbAventure.get("dateStart"));
		
		House house = new House();
		BasicDBObject dbHouse = (BasicDBObject) dbAventure.get("house");
		ObjectId houseObjId = (ObjectId) dbHouse.get("_id");
		house.setId(houseObjId.toString());
		adventure.setHouse(HouseService.fetchHouse(house).toString());
		adventure.setStoryPoints((Integer) dbAventure.get("storyPoints"));
//		adventure.setStoryPointsMonth(storyPointsMonth);
		
		Map<String, Ticket> tickets = new HashMap<>();
		List<BasicDBObject> ticketsList = new ArrayList<>();
		if(dbAventure.get("ticket") != null){
			ticketsList = (List<BasicDBObject>) dbAventure.get("ticket");
			Iterator<BasicDBObject> iterator = ticketsList.iterator();
			while(iterator.hasNext()){
				ObjectId ticketObjId = (ObjectId) iterator.next().get("_id");
				Ticket ticket = new Ticket();
				ticket.setId(ticketObjId);
			}
		}
		adventure.setTickets(tickets); 

		
		return adventure;
	}
	

	@Override
	public WriteResult addAdventure(Adventure adventure) {
		BasicDBObject query = new BasicDBObject();
		query.put("adventureName", adventure.getAdventurename());		
		BasicDBObject adventureObject = new BasicDBObject("adventureName", adventure.getAdventurename())
					.append("house", adventure.getHouse())
					.append("dateStart", new SimpleDateFormat("yyyy-MM-dd").format(adventure.getDateStart()))
					.append("dateEnd", new SimpleDateFormat("yyyy-MM-dd").format(adventure.getDateEnd()))
					.append("ticket", new BasicDBList())
					.append("storyPoints", adventure.getStoryPoints());
		
		BasicDBObject singleQuery = new BasicDBObject();
		query.put("adventureName", adventure.getAdventurename());
		DBObject dbAdventure = adventuresCollection.findOne(singleQuery);
	
		if(dbAdventure != null){
			return adventuresCollection.update(query, adventureObject);
		}
		
		return adventuresCollection.insert(adventureObject);
	}

	@Override
	public WriteResult updateAdventure(Adventure adventure) {
		BasicDBObject query = new BasicDBObject();
		query.put("adventureName", adventure.getAdventurename());
		DBObject dbAdventure = adventuresCollection.findOne(query);
				dbAdventure.put("house", adventure.getHouse());		
				dbAdventure.put("dateStart", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(adventure.getDateStart()));
				dbAdventure.put("dateEnd", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(adventure.getDateEnd()));
				dbAdventure.put("storyPoints", adventure.getStoryPoints());
						
		return adventuresCollection.update(query, dbAdventure);
	}

	@Override
	public Adventure getAdventure(Adventure adventure) {
		BasicDBObject query = new BasicDBObject();
		query.put("adventureName", adventure.getAdventurename());
		DBObject dbTicket = adventuresCollection.findOne(query);
		return this.getAdventure(dbTicket);		
	}

	@Override
	public WriteResult deleteAdventure(Adventure adventure) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addTicketToAdventure(Ticket ticket, String adventureName) {
		
		BasicDBObject query = new BasicDBObject();
		query.put("adventureName", adventureName);
		DBObject dbAdventure = adventuresCollection.findOne(query);
		List<BasicDBObject> ticketsList = new ArrayList<>();
		
		if(dbAdventure.get("ticket") != null){
			ticketsList = (List<BasicDBObject>) dbAdventure.get("ticket");
		}
		
		ticketsList.add(new BasicDBObject("jiraId", ticket.getJiraId()));		
	    
		dbAdventure.put("ticket", ticketsList);
		adventuresCollection.update(query, dbAdventure);		
		
	}



	

	
}

