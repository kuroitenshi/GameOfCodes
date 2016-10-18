package com.misys.gameofcodes.api;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.bo.AddHouseHeroes;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;

@Path("/house")  
public class HouseWS {
  
	/**
	 * gets all houses
	 * /house/all
	 */
	@GET  @Path("all")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<House> getAll() {  
		return  HouseService.fetchHouses();  
	}   
	/**
	 * gets houses by id via POST
	 * /house/id
	 */  
	  @POST  @Path("id")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public House getHouse(House house) {  
		  return  HouseService.fetchHouse(house);  
	  }
	/**
	 * create a new house via POST
	 * /house/create
	 */
	@POST  @Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createHouse(House house) {  
		  HouseService.createHouse(house);;  
	}
	/**
	 * delete a house via POST
	 * /house/delete
	 */
	@POST  @Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteHouse(House house) {  
		  HouseService.deleteHouse(house);  
	}
	/**
	 * update house via POST
	 * /house/update
	 */
	@POST  @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateHouse(House house) {  
		  HouseService.updateHouse(house);  
	}
	/**
	 * add a hero to a house via POST
	 * /house/update/addhero
	 */
	@POST  @Path("update/addhero")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateHouse(AddHouseHeroes addHouseHeroes) {  
		  HouseService.addHouseHero(addHouseHeroes.getHouse(), addHouseHeroes.getHero());  
	}
}  