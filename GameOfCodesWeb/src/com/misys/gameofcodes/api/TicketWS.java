package com.misys.gameofcodes.api;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.TicketService;

@Path("/ticket")  
public class TicketWS {
  
	/**
	 * gets all tickets
	 * /ticket/all
	 */
	@GET  @Path("all")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Ticket> getAll() {  
		return TicketService.fetchTickets();
	}   
	/**
	 * gets ticket by id via POST
	 * /ticket/id
	 */  
	  @POST  @Path("id")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public Ticket getTicket(Ticket ticket) {  
			return TicketService.fetchTicket(ticket);
	  }
	/**
	 * create a new ticket via POST
	 * /ticket/create
	 */
	@POST  @Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTicket(Ticket ticket) {  
		TicketService.addTicket(ticket); 
	}
	/**
	 * delete a ticket via DELETE
	 * /house/delete
	 */
	@DELETE  @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteHouseById(@PathParam("id") String id) {  
		TicketService.deleteTicketById(id);
	}
	/**
	 * delete a ticket via POST
	 * /house/delete
	 */
	@POST  @Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteHouse(Ticket ticket) {  
		TicketService.deleteTicket(ticket); 
	}
	/**
	 * update ticket via POST
	 * /ticket/update
	 */
	@POST  @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTicket(Ticket ticket) {  
		TicketService.updateTicket(ticket);  
	}
}  