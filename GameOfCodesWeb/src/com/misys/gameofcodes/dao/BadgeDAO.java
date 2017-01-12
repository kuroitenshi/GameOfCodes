package com.misys.gameofcodes.dao;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.model.Badge;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface BadgeDAO  {

	List<Badge> getAllBadges();
	Hero getBadge(Badge badge);
	Hero getBadge(DBObject badge);
	WriteResult addBadge(Badge badge);
	WriteResult updateBadge(Badge badge);
	WriteResult deleteBadge(Badge badge);

}
