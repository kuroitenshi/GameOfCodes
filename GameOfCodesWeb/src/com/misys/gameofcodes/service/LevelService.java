package com.misys.gameofcodes.service;

import java.util.List;

import com.misys.gameofcodes.dao.LevelDAO;
import com.misys.gameofcodes.dao.LevelDAOImpl;
import com.misys.gameofcodes.model.Level;
import com.mongodb.WriteResult;

public class LevelService {

	private LevelService() { }
	private static LevelService levelService;
	private static LevelDAO levelDAO = new LevelDAOImpl();
	public static LevelService getTicketService(){
		if (levelService == null){
			levelService = new LevelService();
		}
		return levelService;
	}
	public static List<Level> fetchHouseLevels(){
		return levelDAO.getAllHouseLevels();	
	}
	public static List<Level> fetchHeroLevels(){
		return levelDAO.getAllHouseLevels();	
	}
	public static Level fetchHeroLevel(int points){
		return levelDAO.getHeroLevel(points);	
	}
	public static Level fetchHouseLevel (int points){
		return levelDAO.getHouseLevel(points);	
	}
	public static WriteResult addHouseLevel(Level level){
		return levelDAO.addHouseLevel(level);	
	}
	public static WriteResult addHeroLevel(Level level){
		return levelDAO.addHeroLevel(level);	
	}
	public static WriteResult deleteLevel(Level level){
		return levelDAO.deleteLevel(level);	
	}
	public static WriteResult updateLevel(Level level){
		return levelDAO.updateLevel(level);	
	}
}
