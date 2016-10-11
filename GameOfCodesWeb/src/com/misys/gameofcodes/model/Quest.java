package com.misys.gameofcodes.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.sun.javafx.collections.MappingChange.Map;

@XmlRootElement
public class Quest {
	
	private ObjectId id;
	
	private String questname;
	private Date dateStart;
	private Date dateEnd;
	private Adventure adventure;
	private Hero hero;	
	private int storyPoints;
	private Ticket jiraTicket;
	private String status;
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getQuestname() {
		return questname;
	}
	public void setQuestname(String questname) {
		this.questname = questname;
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
	public Adventure getAdventure() {
		return adventure;
	}
	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public int getStoryPoints() {
		return storyPoints;
	}
	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}
	public Ticket getJiraTicket() {
		return jiraTicket;
	}
	public void setJiraTicket(Ticket jiraTicket) {
		this.jiraTicket = jiraTicket;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	
}
