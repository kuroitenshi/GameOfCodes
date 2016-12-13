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
		//test.addHouseLevels();
		//test.fetchAll();
		//test.fetchHeroLevel(120);
	}
	
	
	private void fetchHeroLevel(int points) {
		System.out.println(EncoderUtility.toJSON(LevelService.fetchHeroLevel(points)));
		
	}


	public void addHeroLevels() {
		Level level = new Level();
		//level
		level.setLevel(1);
		level.setName("Commoner I");
		level.setPoints(0);
		level.setDescription("Bronze Commoner");
		level.setIcon("rank1");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(2);
		level.setName("Commoner II");
		level.setPoints(20);
		level.setDescription("Silver Commoner");
		level.setIcon("rank1");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(3);
		level.setName("Commoner III");
		level.setPoints(30);
		level.setDescription("Golden Commoner");
		level.setIcon("rank1");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(4);
		level.setName("Squire I");
		level.setPoints(50);
		level.setDescription("Bronze Squire");
		level.setIcon("rank2");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(5);
		level.setName("Squire II");
		level.setPoints(70);
		level.setDescription("Silver Squire");
		level.setIcon("rank2");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(6);
		level.setName("Squire III");
		level.setPoints(90);
		level.setDescription("Golden Squire");
		level.setIcon("rank2");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(7);
		level.setName("Knight I");
		level.setPoints(120);
		level.setDescription("Bronze Knight");
		level.setIcon("rank3");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(8);
		level.setName("Knight II");
		level.setPoints(150);
		level.setDescription("Silver Knight");
		level.setIcon("rank3");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(9);
		level.setName("Knight III");
		level.setPoints(180);
		level.setDescription("Golden Knight");
		level.setIcon("rank3");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(10);
		level.setName("Great Knight I");
		level.setPoints(220);
		level.setDescription("Bronze Great Knight");
		level.setIcon("rank4");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(11);
		level.setName("Great Knight II");
		level.setPoints(260);
		level.setDescription("Silver Great Knight");
		level.setIcon("rank4");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(12);
		level.setName("Great Knight III");
		level.setPoints(300);
		level.setDescription("Golden Great Knight");
		level.setIcon("rank4");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(13);
		level.setName("Knight Commander I");
		level.setPoints(350);
		level.setDescription("Bronze Knight Commander");
		level.setIcon("rank5");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(14);
		level.setName("Knight Commander II");
		level.setPoints(400);
		level.setDescription("Silver Knight Commander");
		level.setIcon("rank5");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(15);
		level.setName("Knight Commander III");
		level.setPoints(450);
		level.setDescription("Golden Knight Commander");
		level.setIcon("rank5");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(16);
		level.setName("King I");
		level.setPoints(510);
		level.setDescription("The Bronze King");
		level.setIcon("rank6");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(17);
		level.setName("King II");
		level.setPoints(560);
		level.setDescription("The Silver King");
		level.setIcon("rank6");
		LevelService.addHeroLevel(level);
		//level
		level.setLevel(18);
		level.setName("King III");
		level.setPoints(610);
		level.setDescription("The Golden King");
		level.setIcon("rank6");
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
