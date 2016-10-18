package com.misys.gameofcodes.api;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.bo.AddHouseHeroes;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.utility.EncoderUtility;

@Path("/hero")  
public class HeroWS {
  
	/**
	 * Gets all heroes
	 * /hero/all
	 */
	@GET  @Path("all")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Hero> getAll() {  
		return  HeroService.fetchHeroes();  
	}
	/**
	 * Gets specific hero
	 * /hero/{id}
	 */  
	@POST  @Path("id")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Hero getAccount(Hero hero) {  
		return  HeroService.fetchHero(hero);  
	}
	/**
	 * Gets specific hero by username
	 * /hero/username/{username}
	 */
	@GET  @Path("username/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Hero getAccount(@PathParam("username") String username) {
		Hero hero = new Hero();
		hero.setUsername(username);
		return  HeroService.fetchHero(hero);  
	}
	/**
	 * create a new hero via POST
	 * /hero/create
	 */
	@POST  @Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(Hero hero) {  
	HeroService.createHero(hero);  
	}
	/**
	 * delete a hero via POST
	 * /hero/delete
	 */
	@DELETE  @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") String id) {
	Hero hero = new Hero();
	hero.setId(id);
	HeroService.deleteHero(hero);  
	}
	/**
	 * update a hero via POST
	 * /hero/update
	 */
	@POST  @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(Hero hero) {  
		HeroService.updateHero(hero);  
	}
	/**
	 * assign house to hero via POST
	 * /hero/sethouse
	 */
	@POST  @Path("sethouse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(AddHouseHeroes addHouseHero) {  
		HeroService.updateHeroHouse(addHouseHero.getHero(), addHouseHero.getHouse());  
	}
}  