package com.misys.gameofcodes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.misys.gameofcodes.connection.CollectionProvider;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.Quest;
import com.misys.gameofcodes.model.Ticket;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class QuestDAOImpl implements QuestDAO 
{
	private CollectionProvider collectionProvider;
	private DBCollection questCollection;

	public QuestDAOImpl() 
	{
		collectionProvider = new CollectionProvider();
		questCollection = collectionProvider.getCollection("Quest");
	}
	
	/* 
	 * Gets full quest list
	 */
	@Override
	public List<Quest> getAllQuests() 
	{
		DBCursor cursor = questCollection.find();
        List<Quest> Quests = new ArrayList<Quest>();
        while(cursor.hasNext()){
        	DBObject dbQuest = cursor.next();
        	System.out.println(dbQuest.toString());
        	Quest Quest = this.getQuest(dbQuest);
        	Quests.add(Quest);
        }
		return Quests;		
	}

	/**
	 * Returns quest coming from dbObject
	 * @param dbQuest
	 * @return quest
	 */
	@Override
	public Quest getQuest(DBObject dbQuest) 
	{
		Quest quest = new Quest();
    	ObjectId objId = (ObjectId) dbQuest.get("_id");
    	quest.setId(objId);
    	quest.setQuestname(dbQuest.get("questname").toString());
    	quest.setDateStart((Date) dbQuest.get("dateStart"));
    	quest.setDateEnd((Date) dbQuest.get("dateEnd"));
    	quest.setAdventure((Adventure)dbQuest.get("adventure"));
    	quest.setHero((Hero)dbQuest.get("hero"));    	
    	quest.setStoryPoints((Integer)dbQuest.get("storyPoints"));
    	quest.setJiraTicket((Ticket) dbQuest.get("jiraTicket"));
    			
    	return quest;
	}
	

	/* 
	 * Adds a new quest
	 */
	@Override
	public WriteResult addQuest(Quest quest) 
	{
		BasicDBObject questObject = new BasicDBObject("questname", quest.getQuestname())
				  .append("dateStart", quest.getDateStart())
	      		  .append("dateEnd", quest.getDateEnd())
				  .append("adventure", quest.getAdventure())
				  .append("hero", quest.getHero())
				  .append("storyPoints", quest.getStoryPoints())
				  .append("jiraTicket", quest.getJiraTicket());
		
		return questCollection.insert(questObject);		
	}

	@Override
	public WriteResult updateQuest(Quest Quest) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * Deletes a quest
	 */
	@Override
	public WriteResult deleteQuest(Quest quest) {
		BasicDBObject query = new BasicDBObject("questname", quest.getQuestname())
					.append("jiraTicket", quest.getJiraTicket());
		return questCollection.remove(query);
	}

	@Override
	public WriteResult setInactiveQuest(Quest Quest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quest> getQuestsPerHero(Hero hero) {
		// TODO Auto-generated method stub
		return null;
	}

}
