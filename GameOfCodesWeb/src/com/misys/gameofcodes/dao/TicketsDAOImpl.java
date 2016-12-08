package com.misys.gameofcodes.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Ticket;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class TicketsDAOImpl implements TicketsDAO {

	private CollectionProvider collectionProvider;
	private DBCollection ticketCollection;
	public TicketsDAOImpl()
	{
		collectionProvider = new CollectionProvider();
		ticketCollection = collectionProvider.getCollection("Ticket");
	}
	
	public List<Ticket> getAllTickets() {
		DBCursor cursor = ticketCollection.find();
		List<Ticket> tickets = new ArrayList<Ticket>();
        while(cursor.hasNext()){
        	DBObject dbTicket = cursor.next();
        	Ticket ticket = getTicket(dbTicket);
    		tickets.add(ticket);
        }
		return tickets;
	}
	
	public Ticket getTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("jiraId", ticket.getJiraId());
		DBObject dbTicket = ticketCollection.findOne(query);
		return getTicket(dbTicket);
	}
	
	public Ticket getTicket(DBObject dbTicket){
		Ticket ticket = new Ticket();
		ObjectId objId = (ObjectId) dbTicket.get("_id");
		ticket.setId(objId);
		if (dbTicket.get("jiraId").toString() != null) {
			ticket.setJiraId(dbTicket.get("jiraId").toString()); 
		}
		if (dbTicket.get("title").toString() != null) {
			ticket.setTitle(dbTicket.get("title").toString()); 
		}
		if (dbTicket.get("description").toString() != null) {
			ticket.setDescription(dbTicket.get("description").toString()); 
		}
		if (dbTicket.get("dateStarted").toString() != null) {
			try {
				ticket.setDateStarted(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(dbTicket.get("dateStarted").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if (dbTicket.get("dateVerified").toString().isEmpty()) {
			try {
				ticket.setDateStarted(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(dbTicket.get("dateVerified").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		if (dbTicket.get("status").toString() != null) {
			ticket.setStatus(dbTicket.get("status").toString()); 
		}
		if (dbTicket.get("severity").toString() != null) {
			ticket.setSeverity(dbTicket.get("severity").toString()); 
		}
		if (dbTicket.get("priority").toString() != null) {
			ticket.setPriority(dbTicket.get("priority").toString()); 
		}
		if (dbTicket.get("dateEnd").toString() != null) {
			try {
				ticket.setDateStarted(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(dbTicket.get("dateEnd").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		}
		if (dbTicket.get("developers").toString() != null) {
			List<String> developers = new ArrayList<String>();
			developers.add(dbTicket.get("developers").toString());
			ticket.setDevelopers(developers); 
		}
		if (dbTicket.get("storyPoints").toString() != null) {
			ticket.setStoryPoints((int) Double.parseDouble(dbTicket.get("storyPoints").toString())); 
		}
		return ticket;
	}
	
	public void addTicket(Ticket ticket){
		BasicDBObject query = new  BasicDBObject();
			query.put("jiraId", ticket.getJiraId());
		DBObject dbTicket = new BasicDBObject();	
			dbTicket.put("$set", new BasicDBObject().append("jiraId", ticket.getJiraId())
				.append("title", ticket.getTitle())
				.append("description", "")
				.append("dateStarted", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(ticket.getDateStarted()))
				.append("dateVerified", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(ticket.getDateVerified()))
				.append("status", ticket.getStatus())
				.append("severity", ticket.getSeverity())
				.append("priority", ticket.getPriority())
				.append("dateEnd", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(ticket.getDateEnd()))
				.append("developers", ticket.getDevelopers().get(0))
				.append("storyPoints", ticket.getStoryPoints()));
		ticketCollection.update(query, dbTicket, true, false);	
	}
	
	public void updateTicket(Ticket ticket){
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("jiraId", ticket.getJiraId());
		ticketCollection.update(query, dbTicket);
	}

	public void deleteTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject("jiraId", ticket.getJiraId());
		System.out.println(ticketCollection.remove(query));
		
	}
	public void updateTicketAssign(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("isAssigned", "Y");
		ticketCollection.update(query, dbTicket);
	}
	public void updateTicketUnassign(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("isAssigned", "N");
		ticketCollection.update(query, dbTicket);
	}
	
}
