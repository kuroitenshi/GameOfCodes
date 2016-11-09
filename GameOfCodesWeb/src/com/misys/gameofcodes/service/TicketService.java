package com.misys.gameofcodes.service;

import java.util.Map;

import com.misys.gameofcodes.dao.TicketsDAO;
import com.misys.gameofcodes.dao.TicketsDAOImpl;
import com.misys.gameofcodes.model.Ticket;

public class TicketService {

	private TicketService() { }
	private static TicketService ticketService;
	
	public static TicketService getTicketService(){
		if (ticketService == null){
			ticketService = new TicketService();
		}
		return ticketService;
	}
	
	public Ticket fetchTicket(Ticket ticket){
		TicketsDAO ticketDAO = new TicketsDAOImpl();
		return ticketDAO.getTicket(ticket);		
	}
	
	public Map<String, Ticket> fetchTickets(){
		TicketsDAO ticketDAO = new TicketsDAOImpl();
		return ticketDAO.getAllTickets();
	}
	
	public void addTicket(Ticket ticket){
		TicketsDAO ticketDAO = new TicketsDAOImpl();
		ticketDAO.addTicket(ticket);
	}
	
	public void updateTicket(Ticket ticket){
		TicketsDAO ticketDAO = new TicketsDAOImpl();
		ticketDAO.updateTicket(ticket);
	}
	
	public void deleteTicket(Ticket ticket){
		TicketsDAO ticketsDAO = new TicketsDAOImpl();
		ticketsDAO.deleteTicket(ticket);
	}
}
