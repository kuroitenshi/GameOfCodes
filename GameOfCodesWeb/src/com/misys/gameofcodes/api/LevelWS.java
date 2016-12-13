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
import com.misys.gameofcodes.model.Level;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.service.TicketService;

@Path("/level")  
public class LevelWS {
  
	/**
	 * gets all tickets
	 * /level/heroes
	 */
	@GET  @Path("heroes")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Level> getAllHeroLevels() {  
		return LevelService.fetchHeroLevels();
	}   
	/**
	 * gets all tickets
	 * /level/houses
	 */
	@GET  @Path("houses")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Level> getAll() {  
		return LevelService.fetchHouseLevels();
	} 
}  