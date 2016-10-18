package com.misys.gameofcodes.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import java.util.Map;

@XmlRootElement
public class Adventure {
	
	private String id;
	
	private String adventurename;
	private Date dateStart;
	private Date dateEnd;
	private String house;
	private String storyPoints;
	private Map<String, Integer> storyPointsMonth;
	private Map<String, Quest> quests;
	
	public Adventure(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdventurename() {
		return adventurename;
	}
	public void setAdventurename(String adventurename) {
		this.adventurename = adventurename;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getStoryPoints() {
		return storyPoints;
	}
	public void setStoryPoints(String storyPoints) {
		this.storyPoints = storyPoints;
	}
	public Map<String, Integer> getStoryPointsMonth() {
		return storyPointsMonth;
	}
	public void setStoryPointsMonth(Map<String, Integer> storyPointsMonth) {
		this.storyPointsMonth = storyPointsMonth;
	}
	public Map<String, Quest> getQuests() {
		return quests;
	}
	public void setQuests(Map<String, Quest> quests) {
		this.quests = quests;
	}
	
	
	

	
}
