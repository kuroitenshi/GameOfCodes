package com.misys.gameofcodes.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement
public class Hero {
	private String id;
	
	private String username;
	private String name;
	private House house;
	private String email;
	private int storyPoints;
	private int level;
	private String equipmentHead1;
	private String equipmentHead2;
	private String equipmentHead3;
	private String equipmentUpperBody;
	private String equipmentLowerBody;
	private String equipmentBoots;
	private String equipmentRightHand;
	private String equipmentLeftHand;
	private String equipmentWings;
	private String isActive;
	private String isGameMaster;
//	private Map<String, Badge> badges;
	
	public Hero (){}
	
	public Hero(String username, String name) {
		this.setUsername(username);
		this.setName(name);
	}
	
	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEquipmentHead1() {
		return equipmentHead1;
	}

	public void setEquipmentHead1(String equipmentHead1) {
		this.equipmentHead1 = equipmentHead1;
	}

	public String getEquipmentHead2() {
		return equipmentHead2;
	}

	public void setEquipmentHead2(String equipmentHead2) {
		this.equipmentHead2 = equipmentHead2;
	}

	public String getEquipmentHead3() {
		return equipmentHead3;
	}

	public void setEquipmentHead3(String equipmentHead3) {
		this.equipmentHead3 = equipmentHead3;
	}

	public String getEquipmentUpperBody() {
		return equipmentUpperBody;
	}

	public void setEquipmentUpperBody(String equipmentUpperBody) {
		this.equipmentUpperBody = equipmentUpperBody;
	}

	public String getEquipmentLowerBody() {
		return equipmentLowerBody;
	}

	public void setEquipmentLowerBody(String equipmentLowerBody) {
		this.equipmentLowerBody = equipmentLowerBody;
	}

	public String getEquipmentBoots() {
		return equipmentBoots;
	}

	public void setEquipmentBoots(String equipmentBoots) {
		this.equipmentBoots = equipmentBoots;
	}

	public String getEquipmentRightHand() {
		return equipmentRightHand;
	}

	public void setEquipmentRightHand(String equipmentRightHand) {
		this.equipmentRightHand = equipmentRightHand;
	}

	public String getEquipmentLeftHand() {
		return equipmentLeftHand;
	}

	public void setEquipmentLeftHand(String equipmentLeftHand) {
		this.equipmentLeftHand = equipmentLeftHand;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getEquipmentWings() {
		return equipmentWings;
	}

	public void setEquipmentWings(String equipmentWings) {
		this.equipmentWings = equipmentWings;
	}

	public String getIsGameMaster() {
		return isGameMaster;
	}

	public void setIsGameMaster(String isGameMaster) {
		this.isGameMaster = isGameMaster;
	}

//	public Map<String, Badge> getBadges() {
//		return badges;
//	}
//
//	public void setBadges(Map<String, Badge> badges) {
//		this.badges = badges;
//	}

	
}
