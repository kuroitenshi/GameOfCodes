package com.misys.gameofcodes.service;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.dao.HeroesDAO;
import com.misys.gameofcodes.dao.HeroesDAOImpl;
import com.misys.gameofcodes.dao.HousesDAO;
import com.misys.gameofcodes.dao.HousesDAOImpl;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.MongoClient;

public class HouseService {
	
	private HouseService() {}
	private static HouseService houseService;
	private static HousesDAOImpl houseDAO = new HousesDAOImpl();
    public static HouseService getHouseService(){
        if(houseService == null){
        	houseService = new HouseService();
        }
        return houseService;
    }
	
	public static void addHouse(House house) {
		houseDAO.addHouse(house);		
	}
	
	public static List<House> fetchHouses() {
		return houseDAO.getAllHouses();		
	}
	public static House fetchHouse(House house) {
		return houseDAO.getHouse(house);		
	}
	public static void deleteHouse(House house) {
		houseDAO.deleteHouse(house);
	}
	public static void addHouseHero(House house, Hero hero) {
		houseDAO.addHouseHero(house, hero);
	}
	
}