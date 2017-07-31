package com.misys.gameofcodes.dao;

import java.util.List;
import com.misys.gameofcodes.model.Adventure;
import com.misys.gameofcodes.model.Ticket;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface AdventureDAO  {

	List<Adventure> getAllAdventures();
	List<Adventure> getAllAdventuresByDomain(String domain);
	Adventure getAdventure(Adventure adventure);
	Adventure getAdventure(DBObject dbhero);
	WriteResult addAdventure(Adventure adventure);
	WriteResult updateAdventure(Adventure adventure);
	void deleteAdventure(String adventureName);
	void addTicketToAdventure(Ticket ticket, String adventureName);

}
