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
		hero.setUsername("flash");
		hero.setName("Barry Allen");
		hero.setEmail("speedoflight@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("wonderwoman");
		hero.setName("Diana Prince");
		hero.setEmail("amazonian@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("vision");
		hero.setName("Victor Shade");
		hero.setEmail("godlike@misys.com");
		HeroService.createHero(hero);
		// Add second hero
		hero.setUsername("spiderman");
		hero.setName("Peter Parker");
		hero.setEmail("webslinger@misys.com");
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
