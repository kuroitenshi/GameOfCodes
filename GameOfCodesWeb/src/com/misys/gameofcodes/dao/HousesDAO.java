package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.WriteResult;

public interface HousesDAO  {

	public List<House> getAllHouses();
	public House getHouse(House house);
	public WriteResult addHouse(House house);
	public WriteResult updateHouse(House house);
	public WriteResult deleteHouse(House house);
	public WriteResult addHouseHero(House house, Hero hero);
}
