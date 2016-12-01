package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface HousesDAO  {

	public List<House> getAllHouses();
	public House getHouse(House house);
	public WriteResult createHouse(House house);
	public WriteResult updateHouse(House house);
	public WriteResult deleteHouse(House house);
	public WriteResult deleteHouse(String id);
	public WriteResult addHouseHero(House house, Hero hero);
	public House getHouse(DBObject dbHouse);
	public WriteResult updateHousePoints(House house);
	public WriteResult removeHouseHero(House house, Hero hero);
	
}
