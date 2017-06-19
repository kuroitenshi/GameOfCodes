package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Ticket;
import com.mongodb.DBObject;

public interface TicketsDAO {
	
	List<Ticket> getAllTickets();
	List<Ticket> getCompletedTicketsForDomain(String domain);
	Ticket getTicket(Ticket ticket);
	void addTicket(Ticket ticket);
	void updateTicket(Ticket ticket);
	void deleteTicket(Ticket ticket);
	void deleteTicketById(String ticket);
	void updateTicketAssign(Ticket ticket);	
	void updateTicketUnassign(Ticket ticket);
	Ticket getTicket(DBObject dbTicket);
	int getUserTicketSum(String username);
	int getUserTicketSumMonth(String username);	

}
