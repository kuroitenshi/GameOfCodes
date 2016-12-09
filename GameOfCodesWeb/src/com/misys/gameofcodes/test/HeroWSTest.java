package com.misys.gameofcodes.test;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.utility.EncoderUtility;

public class HeroWSTest {

	public static void main(String[] args) {
		HeroWSTest test = new HeroWSTest();
		test.newHeroes();
		test.fetchAll();
		
	}
	
	public void newHeroes() {
		Hero hero = new Hero();
		// Add first hero
		hero.setUsername("edgresma");
		hero.setName("Edgar Resma");
		hero.setEmail("Edgar.Resma@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("agutierr");
		hero.setName("Aldrich Gutierrez");
		hero.setEmail("AldrichPhilbert.Gutierrez@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("aclimaco");
		hero.setName("April Alcantara");
		hero.setEmail("April.Alcantara@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("rcajigas");
		hero.setName("Rea Cajigas");
		hero.setEmail("Realeen.Cajigas@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("jayperez");
		hero.setName("Jason Perez");
		hero.setEmail("Jayson.Perez@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("jpbautist");
		hero.setName("Peter Bautista");
		hero.setEmail("JanPeter.Bautista@misys.com");
		HeroService.createHero(hero);
	}
	public void fetchAll() {
		System.out.println("Getting all users");
		System.out.println(EncoderUtility.toJSON(HeroService.getHeroService().fetchHeroes()));
	}
	public void fetchUser() {
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
	public void setHouse() {
		Hero hero = new Hero();
		hero.setUsername("batman");
		hero = HeroService.fetchHero(hero);
		House house = new House();
		house.setId("580453ce9dfefc16f00c96f4");
		HeroService.updateHeroHouse(hero, house);
		System.out.println(EncoderUtility.toJSON(HeroService.getHeroService().fetchHero(hero)));
		
	}
}
