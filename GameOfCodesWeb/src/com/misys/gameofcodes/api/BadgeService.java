package com.misys.gameofcodes.api;

import java.util.List;
import java.util.Map;

import com.misys.gameofcodes.dao.BadgeDAO;
import com.misys.gameofcodes.dao.BadgeDAOImpl;
import com.misys.gameofcodes.model.Badge;
import com.mongodb.MongoClient;

public class BadgeService {
	
	private BadgeService() {}
	private static BadgeService badgeService;
	private static BadgeDAOImpl badgeDAO = new BadgeDAOImpl();
    public static BadgeService getBadgeService(){
        if(badgeService == null){
        	badgeService = new BadgeService();
        }
        return badgeService;
    }
	
	public static void addBadge(Badge badge) {
		badgeDAO.addBadge(badge);		
	}
	public static List<Badge> fetchBadges() {
		return badgeDAO.getAllBadges();		
	}
	public static Badge fetchBadge(Badge badge) {
		return badgeDAO.getBadge(badge);		
	}
	public static void deleteBadge(Badge badge) {
		badgeDAO.deleteBadge(badge);
	}
	public static void updateBadge(Badge badge) {
		badgeDAO.updateBadge(badge);
	}

}
