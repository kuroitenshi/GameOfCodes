package com.misys.gameofcodes.test;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.utility.EncoderUtility;

public class HouseWSTest {

	public static void main(String[] args) {
		HouseWSTest test = new HouseWSTest();
		test.fetchAll();
	}
	
	public void newHouses() {
		System.out.println("Adding New Houses");
		House house = new House();
		//add house 1
		house.setHousename("House Stark");
		house.setBanner("Wolf");
		house.setDomain("domain1");
		HouseService.createHouse(house);
		//add house 2
		house.setHousename("House Lannister");
		house.setBanner("Lion");
		house.setDomain("domain2");
		HouseService.createHouse(house);
		//add house 3
		house.setHousename("House Barratheon");
		house.setBanner("Stag");
		house.setDomain("domain3");
		HouseService.createHouse(house);
	}
	public void fetchAll() {
		System.out.println("Getting all Houses");
		System.out.println(EncoderUtility.toJSON(HouseService.fetchHouses()));
	}
	public void fetchHouse() {
		Hero hero = new Hero();
		// Add first hero
		System.out.println("getting by username");
		hero.setUsername("batman");
		System.out.println(EncoderUtility.toJSON(HeroService.getHeroService().fetchHero(hero)));
		System.out.println("getting by id");
		Hero heroById = new Hero();
		hero.setUsername("superman");
		heroById.setId(HeroService.fetchHero(hero).getId());
		System.out.println(EncoderUtility.toJSON(HeroService.getHeroService().fetchHero(heroById)));
	}
}
