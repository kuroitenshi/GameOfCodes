package com.misys.gameofcodes.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Ticket;
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

	public TicketsDAOImpl() {
		collectionProvider = new CollectionProvider();
		ticketCollection = collectionProvider.getCollection("Ticket");
	}

	@Override
	public List<Ticket> getAllTickets() {
		DBCursor cursor = ticketCollection.find();
		List<Ticket> tickets = new ArrayList<Ticket>();
		while (cursor.hasNext()) {
			DBObject dbTicket = cursor.next();
			Ticket ticket = getTicket(dbTicket);
			tickets.add(ticket);
		}
		return tickets;
	}

	@Override
	public List<Ticket> getCompletedTicketsForDomainForCurrentMonth(String domain) {
		BasicDBObject query = new BasicDBObject();
		query.put("house", domain);
		DBCursor cursor = ticketCollection.find(query);
		List<Ticket> tickets = new ArrayList<Ticket>();
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int currentMonth = cal.get(Calendar.MONTH);
		while (cursor.hasNext()) {
			DBObject dbTicket = cursor.next();
			Ticket ticket = getTicket(dbTicket);
			cal.setTime(ticket.getDateVerified());
			int ticketMonth = cal.get(Calendar.MONTH);
			if(currentMonth == ticketMonth){
				tickets.add(ticket);
			}
			
		}
		return tickets;
	}
	
	@Override
	public List<Ticket> getUserTickets(String username) {
		BasicDBObject query = new BasicDBObject();
		query.put("developers", username);
		DBCursor cursor = ticketCollection.find(query);
		List<Ticket> tickets = new ArrayList<Ticket>();

		while (cursor.hasNext()) {
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
		BasicDBObject match = new BasicDBObject("$match", query);
		BasicDBObject group = new BasicDBObject("$group",
				new BasicDBObject("_id", "").append("total", new BasicDBObject("$sum", "$storyPoints")));
		AggregationOutput sumTickets = ticketCollection.aggregate(match, group);
		for (DBObject result : sumTickets.results()) {
			return Integer.parseInt(result.get("total").toString());
		}
		return 0;
	}

	@Override
	public int getUserTicketSumMonth(String username) {
		DBObject query = new BasicDBObject();
		Date startingDate = this.getMonthCurr();
		Date endDate = this.getMonthNext();
		query = QueryBuilder.start().put("developers").is(username).and("dateVerified").greaterThanEquals(startingDate)
				.and("dateVerified").lessThan(endDate).get();
		BasicDBObject match = new BasicDBObject("$match", query);
		BasicDBObject group = new BasicDBObject("$group",
				new BasicDBObject("_id", "").append("total", new BasicDBObject("$sum", "$storyPoints")));
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
	public Ticket getTicket(DBObject dbTicket) {
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
		if (dbTicket.get("priority").toString() != null) {
			ticket.setPriority(dbTicket.get("priority").toString());
		}
		if (dbTicket.get("dateEnd").toString() != null) {
			ticket.setDateEnd((Date) dbTicket.get("dateEnd"));
		}
		if (dbTicket.get("developers") != null) {

			BasicDBList developers = (BasicDBList) dbTicket.get("developers");
			;
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
	public void addTicket(Ticket ticket, String house) {
		BasicDBObject query = new BasicDBObject();
		query.put("jiraId", ticket.getJiraId());
		List<String> developerList = ticket.getDevelopers();
		BasicDBList dbDevelopers = new BasicDBList();
		dbDevelopers.addAll(developerList);
		DBObject dbTicket = new BasicDBObject();
		dbTicket.put("$set",
				new BasicDBObject().append("jiraId", ticket.getJiraId()).append("title", ticket.getTitle())
						.append("description", ticket.getDescription()).append("dateStarted", ticket.getDateStarted())
						.append("dateVerified", ticket.getDateVerified()).append("status", ticket.getStatus())
						.append("priority", ticket.getPriority()).append("dateEnd", ticket.getDateEnd())
						.append("developers", dbDevelopers).append("storyPoints", ticket.getStoryPoints())
						.append("house", house));
		ticketCollection.update(query, dbTicket, true, false);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.getId());
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
