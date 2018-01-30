package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Ticket;
import com.mongodb.DBObject;

public interface TicketsDAO {
	
	List<Ticket> getAllTickets();
	Ticket getTicketsByJiraID(String jiraID);
	List<Ticket> getCompletedTicketsForDomainForCurrentMonth(String domain);
	List<Ticket> getUserTickets(String username);
	Ticket getTicket(Ticket ticket);
	void addTicket(Ticket ticket, String house);
	void updateTicket(Ticket ticket);
	void deleteTicket(Ticket ticket);
	void deleteTicketById(String ticket);
	void updateTicketAssign(Ticket ticket);	
	void updateTicketUnassign(Ticket ticket);
	Ticket getTicket(DBObject dbTicket);
	int getUserTicketSum(String username);
	int getUserTicketSumMonth(String username);	
	List<Ticket> customTicketsFilter(String periodType, String period);

}
