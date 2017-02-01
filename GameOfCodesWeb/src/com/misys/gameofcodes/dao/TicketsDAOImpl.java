package com.misys.gameofcodes.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;


public class TicketsDAOImpl implements TicketsDAO {

	private CollectionProvider collectionProvider;
	private DBCollection ticketCollection;
	public TicketsDAOImpl()
	{
		collectionProvider = new CollectionProvider();
		ticketCollection = collectionProvider.getCollection("Ticket");
	}
	@Override
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
	@Override
	public int getUserTicketSum(String username) {
		BasicDBObject query = new BasicDBObject();
		query.put("developers", username);
		BasicDBObject match = new BasicDBObject(
			    "$match", query
			);
		BasicDBObject group = new BasicDBObject(
			    "$group", new BasicDBObject("_id", "").append(
			        "total", new BasicDBObject( "$sum", "$storyPoints" )
			    )
			);
		AggregationOutput sumTickets = ticketCollection.aggregate(match, group);
		for (DBObject result : sumTickets.results()) {
			return Integer.parseInt(result.get("total").toString());
        }
		return 0;
	}
	@Override
	public int getUserTicketSumMonth(String username) {
		DBObject query = new BasicDBObject();
		query = QueryBuilder.start().put("developers").is(username)
				.and("dateVerified").greaterThanEquals(this.getMonthCurr())
				.and("dateVerified").lessThan(this.getMonthNext())
				.get();
		BasicDBObject match = new BasicDBObject(
			    "$match", query
			);
		BasicDBObject group = new BasicDBObject(
			    "$group", new BasicDBObject("_id", "").append(
			        "total", new BasicDBObject( "$sum", "$storyPoints" )
			    )
			);
		AggregationOutput sumTickets = ticketCollection.aggregate(match, group);

		for (DBObject result : sumTickets.results()) {
			return (int) result.get("total");
        }
		return 0;
	}
	public Date getMonthCurr() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	public Date getMonthNext() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	@Override
	public Ticket getTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("jiraId", ticket.getJiraId());
		DBObject dbTicket = ticketCollection.findOne(query);
		return getTicket(dbTicket);
	}
	@Override
	public Ticket getTicket(DBObject dbTicket){
		Ticket ticket = new Ticket();
	  	ObjectId objId = (ObjectId) dbTicket.get("_id");
		ticket.setId(objId.toString());
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
			ticket.setDateStarted((Date) dbTicket.get("dateStarted")); 
		}
		if (dbTicket.get("dateVerified").toString() != null) {
			ticket.setDateVerified((Date) dbTicket.get("dateVerified"));  
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
			ticket.setDateEnd((Date) dbTicket.get("dateEnd"));   
		}
		if (dbTicket.get("developers") != null) {
			
			BasicDBList developers = (BasicDBList) dbTicket.get("developers");;
			List<String> heroList = new ArrayList<String>();
			Iterator iterator = developers.iterator();
			while (iterator.hasNext()) {
				heroList.add(iterator.next().toString());
			}
			ticket.setDevelopers(heroList); 
		}
		if (dbTicket.get("storyPoints").toString() != null) {
			ticket.setStoryPoints((int) Double.parseDouble(dbTicket.get("storyPoints").toString())); 
		}
		return ticket;
	}
	@Override
	public void addTicket(Ticket ticket){
		BasicDBObject query = new  BasicDBObject();
		query.put("jiraId", ticket.getJiraId());
		List<String> developerList = ticket.getDevelopers();
		BasicDBList dbDevelopers = new BasicDBList();
		dbDevelopers.addAll(developerList);
		DBObject dbTicket = new BasicDBObject();	
			dbTicket.put("$set", new BasicDBObject().append("jiraId", ticket.getJiraId())
				.append("title", ticket.getTitle())
				.append("description", "")
				.append("dateStarted", ticket.getDateStarted())
				.append("dateVerified", ticket.getDateVerified())
				.append("status", ticket.getStatus())
				.append("severity", ticket.getSeverity())
				.append("priority", ticket.getPriority())
				.append("dateEnd",ticket.getDateEnd())
				.append("developers", dbDevelopers)
				.append("storyPoints", ticket.getStoryPoints()));
		ticketCollection.update(query, dbTicket, true, false);	
	}
	@Override
	public void updateTicket(Ticket ticket){
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(ticket.getId()));
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("jiraId", ticket.getJiraId());
		ticketCollection.update(query, dbTicket);
	}
	@Override
	public void deleteTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject("jiraId", ticket.getJiraId());
		System.out.println(ticketCollection.remove(query));
	}
	@Override
	public void deleteTicketById(String id) {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		System.out.println(ticketCollection.remove(query));
	}
	@Override
	public void updateTicketAssign(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("isAssigned", "Y");
		ticketCollection.update(query, dbTicket);
	}
	@Override
	public void updateTicketUnassign(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
		
		DBObject dbTicket = ticketCollection.findOne(query);
		dbTicket.put("isAssigned", "N");
		ticketCollection.update(query, dbTicket);
	}
	
}
