package com.misys.gameofcodes.service;

import java.util.List;

import com.misys.gameofcodes.dao.TicketsDAO;
import com.misys.gameofcodes.dao.TicketsDAOImpl;
import com.misys.gameofcodes.model.Ticket;

public class TicketService {

	private TicketService() { }
	private static TicketService ticketService;
	private static TicketsDAO ticketDAO = new TicketsDAOImpl();
	public static TicketService getTicketService(){
		if (ticketService == null){
			ticketService = new TicketService();
		}
		return ticketService;
	}
	public static Ticket fetchTicket(Ticket ticket){
		return ticketDAO.getTicket(ticket);		
	}
	public static List<Ticket> fetchTickets(){
		return ticketDAO.getAllTickets();
	}
	public static void addTicket(Ticket ticket){
		ticketDAO.addTicket(ticket);
	}
	public static void updateTicket(Ticket ticket){
		ticketDAO.updateTicket(ticket);
	}
	public static void deleteTicket(Ticket ticket){
		ticketDAO.deleteTicket(ticket);
	}
	public static void updateTicketAssign(Ticket ticket){
		ticketDAO.updateTicketAssign(ticket);
	}
	public static void udpateTicketUnassign(Ticket ticket){
		ticketDAO.updateTicketUnassign(ticket);
	}
}
