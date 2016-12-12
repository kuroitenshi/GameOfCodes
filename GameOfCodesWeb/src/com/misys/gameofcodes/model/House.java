package com.misys.gameofcodes.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import java.util.Map;

@XmlRootElement
public class House {
	
	private String id;
	
	private String housename;
	private String banner;
	private String domain;
	private int storyPoints;
	private Map<String, Integer> storyPointsMonth;
	private int level;
	private String isActive;
	private Map<String, Hero> heroes;
	private Map<String, Badge> badges;
	
	public House (){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public Map<String, Integer> getStoryPointsMonth() {
		return storyPointsMonth;
	}

	public void setStoryPointsMonth(Map<String, Integer> storyPointsMonth) {
		this.storyPointsMonth = storyPointsMonth;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Map<String, Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(Map<String, Hero> heroes) {
		this.heroes = heroes;
	}

	public Map<String, Badge> getBadges() {
		return badges;
	}

	public void setBadges(Map<String, Badge> badges) {
		this.badges = badges;
	}
	

	
}
