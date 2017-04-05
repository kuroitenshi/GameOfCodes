package com.misys.gameofcodes.service;

import java.util.ArrayList;
import java.util.List;

import com.misys.gameofcodes.dao.AdventureDAO;
import com.misys.gameofcodes.dao.AdventureDAOImpl;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.Ticket;

public class AdventureService {

	private AdventureService()
	{
		
	}
	private static AdventureService adventureService;
	private static AdventureDAO adventureDAO = new AdventureDAOImpl(); 
	public static AdventureService getAdventureService(){
		if(adventureService == null){
			adventureService = new AdventureService();
		}
		
		return adventureService;
	}
	
	/**
	 * Retrieves all existing adventures
	 * 
	 * @return
	 */
	public static List<Adventure> getAllAdventures(){
		return adventureDAO.getAllAdventures();
	}
	
	/**
	 * Retrieves the adventure by the name
	 * @param adventure
	 * @return
	 */
	public static Adventure getAdventure(Adventure adventure){
		return adventureDAO.getAdventure(adventure);
		
	}
	
	/**
	 * Creates new Adventure
	 * @param adventure
	 */
	public static void addAdventure(Adventure adventure){
		adventureDAO.addAdventure(adventure);
	}
	
	/**
	 * Updates all parameters for the adventure
	 * @param adventure
	 */
	public static void updateAdventure(Adventure adventure){
		adventureDAO.updateAdventure(adventure);
	}
	
	/**
	 * Adds a list of tickets to the adventure object
	 * @param tickets
	 * @param adventureName
	 */
	public static void addTicketToAdventure(Ticket ticket, String adventureName){
		adventureDAO.addTicketToAdventure(ticket, adventureName);
	} 
}
