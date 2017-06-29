package com.misys.gameofcodes.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.misys.gameofcodes.model.Adventure;

/**
 * @author Aldrich Gutierrez
 * - Class that creates an adventure (Sprint) and populates it with tickets
 *
 */
public class AdventureScriptRunner {

	public static void main(String[] args) {
		
		String taskType;
			SprintManager sprintMgr = new SprintManager();
			
			/*
			 * REQUIRED - Adventure Object				 
			 * 
			 * */
			Adventure adventure = new Adventure();
			adventure.setAdventurename(ConstantKeys.EQ_CASHIERDEALS_ADVENTURE);
			
			try {
				adventure.setDateStart(new SimpleDateFormat("yyyy-MM-dd").parse(ConstantKeys.VERIFIED_DATE_STARTYR));
				adventure.setDateEnd(new SimpleDateFormat("yyyy-MM-dd").parse(ConstantKeys.FISCALYEAR_END));
			} catch (ParseException e) {

				e.printStackTrace();
			}		
			adventure.setHouse(ConstantKeys.EQUATION_CASHIERDEALS);
			
			/*
			 * REQUIRED - TASKTYPE
			 * ++++ Current Values (Reference: ConstantKeys class )++++
			 * -> ConstantKeys.ADD_SPRINT = Adds a new Adventure
			 * -> ConstantKeys.UPDATE_SPRINT = Updates Adventure Details
			 * -> ConstantKeys.DELETE_SPRINT = Deletes an Adventure
			 * 
			 * */
			taskType = ConstantKeys.ADD_SPRINT;
			switch(taskType){
			
				case ConstantKeys.ADD_SPRINT:{
					/*
					 * ++++ ADD ADVENTURE ++++
					 * 
					 * -- REQUIREMENTS --
					 * -> Adventure Name (Sprint Name)
					 * -> Start Date (Sprint Start Date)
					 * -> End Date (Sprint End Date)
					 * -> House Name (Designated House Name)	
					 * */	
					sprintMgr.addNewSprint(adventure);
				}break;
				case ConstantKeys.UPDATE_SPRINT:{
					/*
					 * ++++ UPDATE ADVENTURE ++++
					 * 
					 * -- UPDATABLE FIELDS --
					 * -> Adventure Name (Sprint Name)
					 * -> Start Date (Sprint Start Date)
					 * -> End Date (Sprint End Date)
					 * -> House Name (Designated House Name)
					 * -> StoryPoints (Total Points accumulated for the Sprint)	
					 * */	
					sprintMgr.updateSprint(adventure);
				}break;
				case ConstantKeys.DELETE_SPRINT:{
					/*
					 * ++++ DELETE ADVENTURE ++++
					 * 
					 * -- REQUIREMENTS --
					 * -> Adventure Name (Sprint Name)					  
					 * */	
					String adventureToDelete = "";
					sprintMgr.deleteSprint(adventureToDelete);
				}break;
				
			}
	}
}
