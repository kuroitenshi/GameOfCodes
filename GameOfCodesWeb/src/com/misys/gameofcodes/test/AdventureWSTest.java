package com.misys.gameofcodes.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.misys.gameofcodes.dao.AdventureDAO;
import com.misys.gameofcodes.dao.AdventureDAOImpl;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.Quest;

public class AdventureWSTest {

	public static void main(String[] args) throws ParseException{
		
		AdventureDAO adDAO = new AdventureDAOImpl();
		Adventure adventure = new Adventure();
		adventure.setAdventurename("adventurename");
		adventure.setDateStart(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse("013-10-07T23:59:51.205-07:00"));
		adventure.setDateEnd(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse("013-10-07T23:59:51.205-07:00"));
		adventure.setStoryPoints(3);
		adventure.setHouse("House of Essence");
//		adventure.setStoryPointsMonth(storyPointsMonth);
		
		
		
	}

	
}
