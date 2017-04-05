package com.misys.gameofcodes.test;

import java.util.List;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.utility.EncoderUtility;

public class HouseWSTest {

	public static void main(String[] args) {
		HouseWSTest test = new HouseWSTest();
		test.newHouses();
		//test.addHeroesToHouse();
		//test.fetchAll();
		//test.getHousePoints();
	}
	
	private void getHousePoints() {
		House house = new House();
		System.out.println("Hello");
		house.setStoryPoints(HouseService.getHousePoints("Essence Core"));
		house.setLevel(LevelService.fetchHouseLevel(HouseService.getHousePoints("Essence Core")).getLevel());
		HouseService.updateHousePoints(house);
	}

	/*private void addHeroesToHouse() {
		House house = new House();
		house.setDomain("Essence Core");
		List<Hero> heroes = HeroService.fetchHeroes();
		for (Hero hero: heroes) {
			HouseService.addHouseHero(
					HouseService.fetchHouse(house),
					hero
					);
		}
	}*/
	
	private void addHeroesToHouse() {
		House house = new House();
		Hero hero = new Hero();
		house.setDomain("EQ_Lending");
		
		
		hero.setUsername("domingw2");
		hero.setName("Wilson Domingo");
		hero.setEmail("Wilson.Domingo@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		
		// Add second hero
		hero.setUsername("rogedian");
		hero.setName("Rogelio Dian");
		hero.setEmail("Rogelio.Dian@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
		hero.setUsername("mangunf1");
		hero.setName("Felicisimo Mangundayao");
		hero.setEmail("Felicisimo.Mangundayao@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
		hero.setUsername("marquel1");
		hero.setName("Luzviminda Marquez");
		hero.setEmail("Luzviminda.Marquez@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
		hero.setUsername("dalistal");
		hero.setName("Lori Dalistan-Songco");
		hero.setEmail("Lori.Dalistan-Songco@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
		hero.setUsername("blandich");
		hero.setName("Benjamin Joseph Landicho");
		hero.setEmail("BenjaminJoseph.Landicho@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
		hero.setUsername("jmarque2");
		hero.setName("Joshua Marquez Lim");
		hero.setEmail("Joshua.MarquezLim@misys.com");
		HeroService.createHero(hero);
		
		HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
		// Add second hero
				hero.setUsername("jclemen2");
				hero.setName("Jose Maria Clemente");
				hero.setEmail("JoseMaria.Clemente@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
				// Add second hero
				hero.setUsername("jpardill");
				hero.setName("Jerico Pardillo");
				hero.setEmail("Jerico.Pardillo@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
				// Add second hero
				hero.setUsername("gladysyu");
				hero.setName("Gladys Joyce Yu");
				hero.setEmail("GladysJoyce.Yu@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
				// Add second hero
				hero.setUsername("jcristob");
				hero.setName("Jericho Cristobal");
				hero.setEmail("Jericho.Cristobal@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
				// Add second hero
				hero.setUsername("ccalamba");
				hero.setName("Catherine Calamba");
				hero.setEmail("Catherine.Calamba@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));
				// Add second hero
				hero.setUsername("bvictori");
				hero.setName("Bianca Ysabel Victoria");
				hero.setEmail("BiancaYsabel.Victoria@misys.com");
				HeroService.createHero(hero);
				
				HouseService.addHouseHero(HouseService.fetchHouse(house),	HeroService.fetchHero(hero));


	}

	public void newHouses() {
		System.out.println("Adding New Houses");
		House house = new House();
		//add house 1
//		house.setHousename("House Stark");
//		house.setBanner("Wolf");
//		house.setDomain("Essence Core");
//		HouseService.createHouse(house);
//		//add house 2
//		house.setHousename("House Lannister");
//		house.setBanner("Lion");
//		house.setDomain("Essence Teller");
//		HouseService.createHouse(house);
//		//add house 3
//		house.setHousename("House Barratheon");
//		house.setBanner("Stag");
//		house.setDomain("Essence Party");
//		HouseService.createHouse(house);
		
		house.setHousename("House #EXODU");
		house.setBanner("Wolf");
		house.setDomain("Equation Lending");
		HouseService.createHouse(house);
	}
        public void deleteHouse() {
		System.out.println("Deleting House...");
		
		HouseService.deleteHouse("58c23c3f0a51864b004a8ea2"); 
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
