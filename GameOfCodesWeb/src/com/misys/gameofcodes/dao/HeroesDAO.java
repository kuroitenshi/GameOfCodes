package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.WriteResult;

public interface HeroesDAO  {

	public List<Hero> getAllHeroes();
	public Hero getHero(Hero hero);
	public WriteResult addHero(Hero hero);
	public WriteResult updateHero(Hero hero);
	public WriteResult deleteHero(Hero hero);
	public WriteResult updateHeroHouse(Hero hero, House house);
	public WriteResult setActiveHero(Hero hero);
	public WriteResult setInactiveHero(Hero hero);

}
