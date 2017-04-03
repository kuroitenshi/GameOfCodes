package com.misys.gameofcodes.dao;

import java.util.List;

import com.misys.gameofcodes.model.Badge;
import com.misys.gameofcodes.model.Hero;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface BadgeDAO  {
	List<Badge> getAllBadges();
	Badge getBadge(Badge badge);
	Badge getBadge(DBObject badge);
	WriteResult addBadge(Badge badge);
	WriteResult updateBadge(Badge badge);
	WriteResult deleteBadge(Badge badge);
}
