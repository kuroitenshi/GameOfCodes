package com.misys.gameofcodes.dao;

import java.util.Map;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class TicketsDAOImpl implements TicketsDAO {

	private CollectionProvider collectionProvider;
	
	public TicketsDAOImpl()
	{
		collectionProvider = new CollectionProvider();
	}
	
	public Map<String, Ticket> getAllTickets() {
		return null;
	}
	
	public Ticket getTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("jiraId", ticket.getJiraId());
		DBObject dbTicket = collectionProvider.getTicketCollection().findOne(query);
		return getTicket(dbTicket);
	}
	
	public Ticket getTicket(DBObject dbTicket){
		Ticket ticket = new Ticket();
		ObjectId objId = (ObjectId) dbTicket.get("_id"); 
		ticket.setId(objId);
		ticket.setTitle(dbTicket.get("title").toString()); 
		ticket.setPriority(dbTicket.get("priority").toString()); 
		ticket.setSeverity(dbTicket.get("severity").toString()); 
		ticket.setStoryPoints(EncoderUtility.getZeroIfNull(dbTicket.get("story_points").toString()));
		//ticket.setDevelopers(dbTicket.get("developers"));
		
		return ticket;
	}
	
	public void addTicket(Ticket ticket){
		DBCollection ticketCollection = collectionProvider.getTicketCollection();
		BasicDBObject ticketObject = new BasicDBObject("jiraId", ticket.getJiraId())
				.append("title", ticket.getTitle())
				.append("priority", ticket.getPriority())
				.append("severity", ticket.getSeverity())
				.append("story_points", 0);
		ticketCollection.insert(ticketObject);		
	}
	
	public void updateTicket(Ticket ticket){
		DBCollection ticketCollection = collectionProvider.getTicketCollection();
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = collectionProvider.getTicketCollection().findOne(query);
		dbTicket.put("jiraId", ticket.getJiraId());
		ticketCollection.update(query, dbTicket);
	}

	public void deleteTicket(Ticket ticket) {
		DBCollection ticketCollection = collectionProvider.getTicketCollection();
		BasicDBObject query = new BasicDBObject("jiraId", ticket.getJiraId());
		System.out.println(ticketCollection.remove(query));
		
	}
	
	
}
