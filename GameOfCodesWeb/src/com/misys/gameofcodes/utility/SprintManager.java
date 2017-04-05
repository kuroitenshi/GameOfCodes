package com.misys.gameofcodes.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.service.AdventureService;

public class SprintManager {


	
	public String addNewSprint(){
		
		/*
		 * Add Sprint Example
		 * 	
		 * */
		Adventure adventure = new Adventure();
		adventure.setAdventurename("EQLENDING_ADVENTURE_ISTINA");
		
		try {
			adventure.setDateStart(new SimpleDateFormat("yyyy-MM-dd").parse("2017-05-01"));
			adventure.setDateEnd(new SimpleDateFormat("yyyy-MM-dd").parse("2017-08-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		adventure.setHouse("EQ_LENDING");
		AdventureService.addAdventure(adventure);
		
		return adventure.getAdventurename();

	}
	
	

}
