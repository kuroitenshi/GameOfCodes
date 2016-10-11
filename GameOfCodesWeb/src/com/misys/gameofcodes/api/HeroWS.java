package com.misys.gameofcodes.api;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.service.HeroService;

@Path("/hero")  
public class HeroWS {
  
  // This method is called if HTML is requested  
  @GET  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)  
  public List<Hero> getAll() {  
    return  HeroService.fetchHeroes();  
  }   
  // This method is called if HTML is requested  
  @POST  @Path("id")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Hero getAccount(Hero hero) {  
    return  HeroService.fetchHero(hero);  
  }
}  