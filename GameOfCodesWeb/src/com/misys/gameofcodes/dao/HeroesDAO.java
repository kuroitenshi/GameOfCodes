package com.misys.gameofcodes.dao;

import java.util.List;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface HeroesDAO  {

	List<Hero> getAllHeroes();
	Hero getHero(Hero hero);
	Hero getHero(DBObject hero);
	WriteResult addHero(Hero hero);
	WriteResult updateHero(Hero hero);
	WriteResult deleteHero(Hero hero);
	WriteResult updateHeroHouse(Hero hero, House house);
	WriteResult setActiveHero(Hero hero);
	WriteResult setInactiveHero(Hero hero);
	WriteResult updateHeroPoints(Hero hero);

}
