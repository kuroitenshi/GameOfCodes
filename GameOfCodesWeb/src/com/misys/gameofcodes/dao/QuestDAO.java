package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.Quest;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;


public interface QuestDAO 
{
	public List<Quest> getAllQuests();
	public Quest getQuest(DBObject dbQuest);
	public WriteResult addQuest(Quest Quest);
	public WriteResult updateQuest(Quest Quest);
	public WriteResult deleteQuest(Quest Quest);
	public WriteResult setInactiveQuest(Quest Quest);
	public List<Quest> getQuestsPerHero (Hero hero);
	
}
