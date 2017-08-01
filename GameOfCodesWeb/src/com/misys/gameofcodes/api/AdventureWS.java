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
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.service.AdventureService;


@Path("/adventure")
public class AdventureWS {
	
	/**
	 * Gets all adventures
	 * /adventure/all
	 */
	@GET  @Path("all")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Adventure> getAll() {  
		return  AdventureService.getAllAdventures();  
	}
	
	/**
	 * Gets specific adventure
	 * /adventure/{name}
	 */  
	@GET  @Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Adventure getAdventure(@PathParam("name") String name) {
		Adventure adventure = new Adventure();
		adventure.setAdventurename(name);
		return  AdventureService.getAdventure(adventure);  
	}
	/**
	 * Get adventures by domain
	 * /adventure/all/domain/{domain}
	 */
	@GET  @Path("all/domain/{domain}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <Adventure> getAdventuresByDomain(@PathParam("domain") String domain) {
		return  AdventureService.getAllAdventuresByDomain(domain);  
	}
	/**
	 * create a new adventure via POST
	 * /adventure/create
	 */
	@POST  @Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createAdventure(Adventure adventure) {  
		AdventureService.addAdventure(adventure);  
	}
	/**
	 * delete an adventure via POST
	 * /adventure/delete
	 */
	@DELETE  @Path("delete/{adventureName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAdventure(@PathParam("adventureName") String adventureName) {
		AdventureService.deleteAdventure(adventureName);  
	}
	/**
	 * update an Adventure via POST
	 * /adventure/update
	 */
	@POST  @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAdventure(Adventure adventure) {  
		AdventureService.updateAdventure(adventure);  
	}
}
