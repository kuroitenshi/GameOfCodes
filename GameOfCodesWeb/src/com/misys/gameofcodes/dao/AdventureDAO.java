package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface AdventureDAO  {

	List<Adventure> getAllAdventures();
	Adventure getAdventure(Adventure adventure);
	Adventure getAdventure(DBObject dbhero);
	WriteResult addAdventure(Adventure adventure);
	WriteResult updateAdventure(Adventure adventure);
	WriteResult deleteAdventure(Adventure adventure);

}
