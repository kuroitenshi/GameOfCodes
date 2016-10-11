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
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;

@Path("/house")  
public class HouseWS {
  
  // This method is called if HTML is requested  
  @GET  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)  
  public List<House> getAll() {  
    return  HouseService.fetchHouses();  
  }   
  // This method is called if HTML is requested  
  @POST  @Path("id")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public House getHouse(House house) {  
    return  HouseService.fetchHouse(house);  
  }
}  