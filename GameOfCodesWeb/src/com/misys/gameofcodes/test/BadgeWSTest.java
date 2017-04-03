package com.misys.gameofcodes.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.misys.gameofcodes.api.BadgeService;
import com.misys.gameofcodes.dao.BadgeDAO;
import com.misys.gameofcodes.dao.BadgeDAOImpl;
import com.misys.gameofcodes.model.Badge;
import com.misys.gameofcodes.utility.EncoderUtility;


public class BadgeWSTest {
	
	
	public static void main(String[] args) throws ParseException{
		
		BadgeWSTest test = new BadgeWSTest();
	    
	   	test.addNewBadge();
	//  test.updateBadge("Level3");
	//  test.deleteBadge("Level3");
		test.fetchAll();
		
	}

	
	public void addNewBadge() throws ParseException{
		
//		BadgeDAOImpl addDAO= new BadgeDAOImpl();
		Badge badge = new Badge();
		badge.setBadgeName("Level3");
		badge.setDescription("Level 2 badge for Hero");
		badge.setBadgeType("HeroBadge");
		badge.setImageId("Hlevel2");
		BadgeService.addBadge(badge);
// 	    addDAO.addBadge(badge);
		
	}
	
	
	public void deleteBadge(String badgeName){
		Badge badge = new Badge();
		badge.setBadgeName(badgeName);
		BadgeService.deleteBadge(badge);
		System.out.println("Badge Deleted...");
	}
	
	
	public void updateBadge(String badgeName){
		Badge badge = new Badge();
		badge.setDescription("Level 5 badge for hero");
		BadgeService.updateBadge(badge);
		System.out.println("Badge Updated...");
	}
	
	public void fetchAll() {

		System.out.println(EncoderUtility.toJSON(BadgeService.getBadgeService().fetchBadges()));
		System.out.println("Getting all badges");
	}
	
	
}
