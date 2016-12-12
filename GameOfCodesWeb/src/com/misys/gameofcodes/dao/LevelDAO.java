package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.Level;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface LevelDAO  {

	List<Level> getAllHeroLevels();
	List<Level> getAllHouseLevels();
	WriteResult addHeroLevel(Level level);
	WriteResult addHouseLevel(Level level);
	WriteResult updateLevel(Level level);
	WriteResult deleteLevel(Level level);
	Level getLevel(Level level);
	Level getLevel(DBObject dbLevel);
	Level getHeroLevel(int points);
	Level getHouseLevel(int points);
}
