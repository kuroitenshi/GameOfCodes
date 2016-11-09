package com.misys.gameofcodes.dao;

import java.util.Map;

import com.misys.gameofcodes.model.Ticket;

public interface TicketsDAO {
	
	public Map<String, Ticket> getAllTickets();
	public Ticket getTicket(Ticket ticket);
	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket);
	public void deleteTicket(Ticket ticket);	

}
