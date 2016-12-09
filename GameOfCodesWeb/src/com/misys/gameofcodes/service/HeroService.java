package com.misys.gameofcodes.service;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.dao.HeroesDAO;
import com.misys.gameofcodes.dao.HeroesDAOImpl;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.MongoClient;

public class HeroService {
	
	private HeroService() {}
	private static HeroService heroService;
	private static HeroesDAO heroDAO = new HeroesDAOImpl();
    public static HeroService getHeroService(){
        if(heroService == null){
        	heroService = new HeroService();
        }
        return heroService;
    }	
	public static Hero fetchHero(Hero hero) {
		return heroDAO.getHero(hero);			
	}
	public static List<Hero> fetchHeroes() {
		return heroDAO.getAllHeroes();		
	}
	public static void createHero(Hero hero) {
		heroDAO.addHero(hero);
	}
	public static void deleteHero(Hero hero) {
		heroDAO.deleteHero(hero);
	}
	public static void updateHero(Hero hero) {
		heroDAO.updateHero(hero);
	}
	public static void updateHeroPoints(Hero hero) {
		heroDAO.updateHeroPoints(hero);
	}
	public static void updateHeroHouse(Hero hero, House house) {
		heroDAO.updateHeroHouse(hero, house);
	}
}