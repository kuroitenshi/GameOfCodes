package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Item;
import com.misys.gameofcodes.model.Hero;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface ItemDAO  {

	List<Item> getAllItems();
	Hero getItem(Item item);
	Hero getItem(DBObject item);
	WriteResult addItem(Item item);
	WriteResult updateItem(Item item);
	WriteResult deleteItem(Item item);

}
