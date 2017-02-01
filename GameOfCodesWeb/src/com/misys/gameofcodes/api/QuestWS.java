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

import com.misys.gameofcodes.model.Quest;
import com.misys.gameofcodes.service.QuestService;
import com.mongodb.DBObject;

@Path("/quest")
public class QuestWS {
	/**
	 * gets all quests
	 * /quest/all
	 */
	@GET  @Path("all")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Quest> getAll() {  
		return QuestService.fetchQuests();
	}   
	/**
	 * gets quest by id via POST
	 * /quest/id
	 */  
	  @POST  @Path("id")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public Quest getQuest(DBObject quest) {  
			return QuestService.fetchQuest(quest);
	  }
	/**
	 * create a new ticket via POST
	 * /ticket/create
	 */
	@POST  @Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createQuest(Quest quest) {  
		QuestService.addQuest(quest); 
	}
	/**
	 * delete a quest via DELETE
	 * /quest/delete
	 */
	@DELETE  @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteQuestByID(@PathParam("id") String id) {  
		QuestService.deleteQuestByID(id);
	}
	/**
	 * delete a quest via POST
	 * /quest/delete
	 */
	@POST  @Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteQuest(Quest quest) {  
		QuestService.deleteQuest(quest); 
	}
	/**
	 * update quest via POST
	 * /quest/update
	 */
	@POST  @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateQuest(Quest ticket) {  
		QuestService.updateQuest(ticket);  
	}
}
