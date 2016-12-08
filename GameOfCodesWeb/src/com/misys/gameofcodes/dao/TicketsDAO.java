package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Ticket;

public interface TicketsDAO {
	
	public List<Ticket> getAllTickets();
	public Ticket getTicket(Ticket ticket);
	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket);
	public void deleteTicket(Ticket ticket);
	public void updateTicketAssign(Ticket ticket);	
	public void updateTicketUnassign(Ticket ticket);	

}
