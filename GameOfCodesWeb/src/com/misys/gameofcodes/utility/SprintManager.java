package com.misys.gameofcodes.utility;

import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.service.AdventureService;

public class SprintManager {
	
	public void addNewSprint(Adventure adventure){			
		AdventureService.addAdventure(adventure);
	}
	
	public void updateSprint(Adventure adventure){
		AdventureService.updateAdventure(adventure);
	}
	
	public void deleteSprint(String adventureName){
		AdventureService.deleteAdventure(adventureName);
	}
	
	

}
