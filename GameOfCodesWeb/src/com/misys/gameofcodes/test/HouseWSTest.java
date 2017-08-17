package com.misys.gameofcodes.test;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.utility.ConstantKeys;
import com.misys.gameofcodes.utility.EncoderUtility;

public class HouseWSTest {

	public static void main(String[] args) {
		HouseWSTest test = new HouseWSTest();
		test.newHouses();
		test.addHeroesToHouse();
		// test.addHeroesToHouse();
		// test.fetchAll();
		// test.getHousePoints();
	}

	private void getHousePoints() {
		House house = new House();
		System.out.println("Hello");
		house.setStoryPoints(HouseService.getHousePoints("Essence Core"));
		house.setLevel(LevelService.fetchHouseLevel(HouseService.getHousePoints("Essence Core")).getLevel());
		HouseService.updateHousePoints(house);
	}

	/*
	 * private void addHeroesToHouse() { House house = new House();
	 * house.setDomain("Essence Core"); List<Hero> heroes =
	 * HeroService.fetchHeroes(); for (Hero hero: heroes) {
	 * HouseService.addHouseHero( HouseService.fetchHouse(house), hero ); } }
	 */

	private void addHeroesToHouse() {
		
		House house = new House();
		Hero hero = new Hero();
		
		house.setDomain(ConstantKeys.EQUATION_ACCOUNTS);

		hero.setUsername("abiadm1");
		hero.setName("Maricris Abiad-Tan");
		hero.setEmail("Maricris.AbiadTan@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("avecill1");
		hero.setName("Leilani Avecilla-Naguit");
		hero.setEmail("Leilani.Avecilla-Naguit@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("cvillanu");
		hero.setName("Cole Villanueva");
		hero.setEmail("Cole.Villanueva@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("domingj1");
		hero.setName("Jermaine Domingo");
		hero.setEmail("Jermaine.Domingo@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));

		hero.setUsername("erolesm1");
		hero.setName("Mayette Eroles");
		hero.setEmail("Marieta.Eroles@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));

		hero.setUsername("glennlim");
		hero.setName("Glenn Lim");
		hero.setEmail("Glenn.Lim@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("jeguzman");
		hero.setName("Jelene Guzman");
		hero.setEmail("Jelene.Guzman@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("justduka");
		hero.setName("Justin Duka");
		hero.setEmail("Justin.Duka@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("marpaule");
		hero.setName("Mark Paule");
		hero.setEmail("MarkAllan.Paule@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("melgarev");
		hero.setName("Vivien Melgarejo");
		hero.setEmail("Vivien.Melgarejo@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("palicpir");
		hero.setName("Ronnie");
		hero.setEmail("Ronnie.Palicpic@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("rtrillan");
		hero.setName("Rhonald Trillana");
		hero.setEmail("RhonaldChristian.Trillana@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
		hero.setUsername("vinveluz");
		hero.setName("Vincent Veluz");
		hero.setEmail("VincentCarlo.Veluz@misys.com");
		HeroService.createHero(hero);

		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
		
//		hero.setUsername("melvchan");
//		hero.setName("Melvin Chan");
//		hero.setEmail("Melvin.Chan@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("jcortado");
//		hero.setName("Junard Laurence Cortado");
//		hero.setEmail("JunardLaurence.Cortado@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("kgangano");
//		hero.setName("Kristelle Joyce Gangano");
//		hero.setEmail("KristelleJoyce.Gangano@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("garcial");
//		hero.setName("Doy Garcia");
//		hero.setEmail("LaurelJoy.Garcia@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//
//		hero.setUsername("lpracull");
//		hero.setName("Lorenzo Pracullos");
//		hero.setEmail("Lorenzo.Pracullos@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//
//		hero.setUsername("kurtsiao");
//		hero.setName("Kurt Patrick Siao");
//		hero.setEmail("KurtPatrick.Siao@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("tanj2");
//		hero.setName("John Patrick Tan");
//		hero.setEmail("John.Tan@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("calongc1");
//		hero.setName("Christian Calonge");
//		hero.setEmail("Christian.Calonge@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("rjtedoco");
//		hero.setName("RJay Tedoco");
//		hero.setEmail("RJay.Tedoco@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//
//		
//		hero.setUsername("domingw2");
//		hero.setName("Wilson Domingo");
//		hero.setEmail("Wilson.Domingo@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//
//		// Add second hero
//		hero.setUsername("rogedian");
//		hero.setName("Rogelio Dian");
//		hero.setEmail("Rogelio.Dian@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("mangunf1");
//		hero.setName("Felicisimo Mangundayao");
//		hero.setEmail("Felicisimo.Mangundayao@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("marquel1");
//		hero.setName("Luzviminda Marquez");
//		hero.setEmail("Luzviminda.Marquez@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("dalistal");
//		hero.setName("Lori Dalistan-Songco");
//		hero.setEmail("Lori.Dalistan-Songco@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("blandich");
//		hero.setName("Benjamin Joseph Landicho");
//		hero.setEmail("BenjaminJoseph.Landicho@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("jmarque2");
//		hero.setName("Joshua Marquez Lim");
//		hero.setEmail("Joshua.MarquezLim@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("jclemen2");
//		hero.setName("Jose Maria Clemente");
//		hero.setEmail("JoseMaria.Clemente@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("jpardill");
//		hero.setName("Jerico Pardillo");
//		hero.setEmail("Jerico.Pardillo@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("gladysyu");
//		hero.setName("Gladys Joyce Yu");
//		hero.setEmail("GladysJoyce.Yu@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("jcristob");
//		hero.setName("Jericho Cristobal");
//		hero.setEmail("Jericho.Cristobal@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("ccalamba");
//		hero.setName("Catherine Calamba");
//		hero.setEmail("Catherine.Calamba@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		// Add second hero
//		hero.setUsername("bvictori");
//		hero.setName("Bianca Ysabel Victoria");
//		hero.setEmail("BiancaYsabel.Victoria@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		 
//		house = new House();
//		house.setDomain(ConstantKeys.ESSENCE_CORE);
//		
//		hero.setUsername("agutierr");
//		hero.setName("Aldrich Philbert Gutierrez");
//		hero.setEmail("AldrichPhilbert.Gutierrez@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("jpbautis");
//		hero.setName("Jan Peter Bautista");
//		hero.setEmail("JanPeter.Bautista@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("aclimaco");
//		hero.setName("April Alcantara");
//		hero.setEmail("April.Alcantara@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("jayperez");
//		hero.setName("Jayson Perez");
//		hero.setEmail("Jayson.Perez@misys.com");
//		HeroService.createHero(hero);
//		 
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("edgresma");
//		hero.setName("Edgar Resma");
//		hero.setEmail("Edgar.Resma@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("rcajigas");
//		hero.setName("Realeen Cajigas");
//		hero.setEmail("Realeen.Cajigas@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
//		
//		hero.setUsername("arlozano");
//		hero.setName("Arman Lozano");
//		hero.setEmail("Arman.Lozano@misys.com");
//		HeroService.createHero(hero);
//
//		HouseService.addHouseHero(HouseService.fetchHouse(house), HeroService.fetchHero(hero));
			
		
	}

	public void newHouses() {
		
		System.out.println("Adding New Houses");
		
		House house = new House();
		house.setHousename("House Lyf");
		house.setBanner("Ghost");
		house.setDomain(ConstantKeys.EQUATION_ACCOUNTS);
		HouseService.createHouse(house);
		
//		house = new House();
//		house.setHousename("House Stark");
//		house.setBanner("Wolf");
//		house.setDomain(ConstantKeys.ESSENCE_CORE);
//		HouseService.createHouse(house);
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
