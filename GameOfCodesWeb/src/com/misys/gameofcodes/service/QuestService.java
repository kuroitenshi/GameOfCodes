package com.misys.gameofcodes.service;

import java.util.List;

import com.misys.gameofcodes.dao.QuestDAO;
import com.misys.gameofcodes.dao.QuestDAOImpl;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.Quest;

public class QuestService {
	private QuestService() {
	}

	private static QuestService questService;
	private static QuestDAO questDAO = new QuestDAOImpl();

	public static QuestService getQuestService() {
		if (questService == null) {
			questService = new QuestService();
		}
		return questService;
	}

	public static List<Quest> getAllQuests() {
		return questDAO.getAllQuests();
	}

	public static void addQuest(Quest quest) {
		questDAO.addQuest(quest);
	}

	public static void updateQuest(Quest quest) {
		questDAO.updateQuest(quest);
	}

	public static void deleteQuest(Quest quest) {
		questDAO.deleteQuest(quest);
	}

	public static void setQuestToActive(Quest quest) {
		questDAO.setQuestToActive(quest);
	}

	public static void setQuestToInactive(Quest quest) {
		questDAO.setQuestToInactive(quest);
	}

	public static List<Quest> getQuestsPerHero(Hero hero) {
		return questDAO.getQuestsPerHero(hero);
	}

}
