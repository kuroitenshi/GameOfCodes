package com.misys.gameofcodes.dao;

import java.util.List;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface HousesDAO  {

	List<House> getAllHouses();
	House getHouse(House house);
	House getHouseByHero(Hero hero);
	WriteResult createHouse(House house);
	WriteResult updateHouse(House house);
	WriteResult deleteHouse(House house);
	WriteResult deleteHouse(String id);
	WriteResult addHouseHero(House house, Hero hero);
	House getHouse(DBObject dbHouse);
	WriteResult updateHousePoints(House house);
	WriteResult removeHouseHero(House house, Hero hero);
	int getHousePoints(String username);
	
}
