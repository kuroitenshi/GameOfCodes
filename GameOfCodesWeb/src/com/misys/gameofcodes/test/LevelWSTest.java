package com.misys.gameofcodes.test;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.Level;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.utility.EncoderUtility;

public class LevelWSTest {

	public static void main(String[] args) {
		LevelWSTest test = new LevelWSTest();
		//test.addHeroLevels();
//		/test.addHouseLevels();
		//test.fetchAll();
		test.fetchHeroLevel(120);
	}
	
	
	private void fetchHeroLevel(int points) {
		System.out.println(EncoderUtility.toJSON(LevelService.fetchHeroLevel(points)));
		
	}


	public void addHeroLevels() {
		Level level = new Level();
		//level
		level.setLevel(1);
		level.setName("level");
		level.setPoints(0);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(2);
		level.setName("level");
		level.setPoints(20);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(3);
		level.setName("level");
		level.setPoints(40);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(4);
		level.setName("level");
		level.setPoints(55);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(5);
		level.setName("level");
		level.setPoints(70);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(6);
		level.setName("level");
		level.setPoints(85);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(7);
		level.setName("level");
		level.setPoints(100);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(8);
		level.setName("level");
		level.setPoints(120);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(9);
		level.setName("level");
		level.setPoints(140);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(10);
		level.setName("level");
		level.setPoints(165);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(11);
		level.setName("level");
		level.setPoints(190);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(12);
		level.setName("level");
		level.setPoints(220);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(13);
		level.setName("level");
		level.setPoints(250);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(14);
		level.setName("level");
		level.setPoints(300);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(15);
		level.setName("level");
		level.setPoints(350);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(16);
		level.setName("level");
		level.setPoints(400);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHeroLevel(level);
	}
	public void addHouseLevels() {
		Level level = new Level();
		//level
		level.setLevel(1);
		level.setName("level");
		level.setPoints(0);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(2);
		level.setName("level");
		level.setPoints(121);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(3);
		level.setName("level");
		level.setPoints(250);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(4);
		level.setName("level");
		level.setPoints(325);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(5);
		level.setName("level");
		level.setPoints(400);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(6);
		level.setName("level");
		level.setPoints(500);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(7);
		level.setName("level");
		level.setPoints(600);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(8);
		level.setName("level");
		level.setPoints(725);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(9);
		level.setName("level");
		level.setPoints(850);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(10);
		level.setName("level");
		level.setPoints(1000);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(11);
		level.setName("level");
		level.setPoints(1150);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(12);
		level.setName("level");
		level.setPoints(1325);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(13);
		level.setName("level");
		level.setPoints(1500);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(14);
		level.setName("level");
		level.setPoints(1750);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(15);
		level.setName("level");
		level.setPoints(2000);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
		//level
		level.setLevel(16);
		level.setName("level");
		level.setPoints(2250);
		level.setDescription("desc");
		level.setIcon("icon");
		LevelService.addHouseLevel(level);
	}
	public void fetchAll() {
		System.out.println("Getting all House Levels");
		System.out.println(EncoderUtility.toJSON(LevelService.fetchHouseLevels()));
		System.out.println("Getting all  Levels");
		System.out.println(EncoderUtility.toJSON(LevelService.fetchHeroLevels()));
	}
}
