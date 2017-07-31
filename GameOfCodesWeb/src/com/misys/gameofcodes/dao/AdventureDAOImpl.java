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
import com.misys.gameofcodes.service.TicketService;
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

	/**
	 * Get all adventures by domain
	 */
	public List<Adventure> getAllAdventuresByDomain(String domain) {
		BasicDBObject query = new BasicDBObject();
		query.put("house", domain);
		DBCursor cursor = adventuresCollection.find(query);
		List<Adventure> Adventures = new ArrayList<Adventure>();
		while(cursor.hasNext()){
			DBObject dbAdventure = cursor.next();
			Adventure Adventure = this.getAdventure(dbAdventure);
			Adventures.add(Adventure);
		}
		return Adventures;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Adventure getAdventure(DBObject dbAventure) {
		Adventure adventure = new Adventure();
		ObjectId objId = (ObjectId) dbAventure.get("_id");
		adventure.setId(objId);
		adventure.setAdventurename(dbAventure.get("adventureName").toString());
		//adventure.setDateEnd((Date) dbAventure.get("dateEnd"));
		//adventure.setDateStart((Date) dbAventure.get("dateStart"));
		
	/*	House house = new House();
		BasicDBObject dbHouse = (BasicDBObject) dbAventure.get("house");
		ObjectId houseObjId = (ObjectId) dbHouse.get("_id");
		house.setId(houseObjId.toString());
		adventure.setHouse(HouseService.fetchHouse(house).toString());
	*/
		adventure.setHouse((String) dbAventure.get("house"));
		adventure.setStoryPoints((Integer) dbAventure.get("storyPoints"));
//		adventure.setStoryPointsMonth(storyPointsMonth);
		
		Map<String, Ticket> tickets = new HashMap<>();
		List<BasicDBObject> ticketsList = new ArrayList<>();
		if(dbAventure.get("ticket") != null){
			ticketsList = (List<BasicDBObject>) dbAventure.get("ticket");
			Iterator<BasicDBObject> iterator = ticketsList.iterator();
			while(iterator.hasNext()){
				Ticket ticket = new Ticket();
				ticket = TicketService.fetchTicketByJiraID((String) iterator.next().get("jiraId"));
				tickets.put(ticket.getId().toString(), ticket);
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
		singleQuery.put("adventureName", adventure.getAdventurename());
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
				dbAdventure.put("adventureName", adventure.getAdventurename());	
				dbAdventure.put("house", adventure.getHouse());		
				dbAdventure.put("dateStart", new SimpleDateFormat("yyyy-MM-dd").format(adventure.getDateStart()));
				dbAdventure.put("dateEnd", new SimpleDateFormat("yyyy-MM-dd").format(adventure.getDateEnd()));
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
	public void deleteAdventure(String adventureName) {
		BasicDBObject query = new BasicDBObject();
		query.put("adventureName", adventureName);		
		
		adventuresCollection.findAndRemove(query);
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
		
		if(!ticketsList.contains(new BasicDBObject("jiraId", ticket.getJiraId()))){
			ticketsList.add(new BasicDBObject("jiraId", ticket.getJiraId()));		
		}    
		dbAdventure.put("ticket", ticketsList);
		adventuresCollection.update(query, dbAdventure);		
		
	}



	

	
}

