package com.misys.gameofcodes.connection;

import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.dao.HeroesDAO;
import com.misys.gameofcodes.dao.HeroesDAOImpl;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import static com.misys.gameofcodes.model.Hero.*;

public class MongoCreateDatabase {

	public static void main(String[] Args) {
//		HeroService.getHeroService().fetchHeroes();
//		Hero hero = new Hero();
//		hero.setId(new ObjectId("57dd84bee2352c036cef60f0"));
//		hero.setName("Edgar Resma");
//		hero.setEmail("edgar.resmas@misys.com");
//		hero.setUsername("edgresma");
//		HeroService.getHeroService().addHero(hero);
//		HeroService.getHeroService().deleteHero(hero);
//		HeroService.getHeroService().fetchHeroes();
//		House house = new House();
//		HouseService.getHouseService().fetchHouses();
//		Hero fetchHero = HeroService.getHeroService().fetchHero(hero);
//		System.out.println(fetchHero.getId());
//		fetchHero.setName("Edgar Resma Jr");
//		System.out.println("New Data");
//		System.out.println(fetchHero.getId());
//		System.out.println(fetchHero.getName());
//		System.out.println(fetchHero.getUsername());
//		HeroService.getHeroService().updateHero(fetchHero);
//		HeroService.getHeroService().fetchHeroes();
//		HouseService.getHouseService().fetchHouses();
//		57dfb4ca07d0f80e8cd81161
//		House house = new House();
//		house.setId(new ObjectId("57dfb04f07d0f803cccd7b77"));
//		
//		HeroService.getHeroService().updateHeroHouse(hero, house);
//		
//		HouseService.getHouseService().fetchHouses();
//		HeroService.getHeroService().fetchHeroes();
	}
	
}