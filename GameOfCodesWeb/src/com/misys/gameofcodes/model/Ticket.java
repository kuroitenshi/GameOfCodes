package com.misys.gameofcodes.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ticket {
	
	private Object id;
	
	private String jiraId;
	private String title;
	private String description;
	private Date dateStarted;
	private Date dateVerified;
	private String status;	
	private String priority;
	private Date dateEnd;
	private List<String> developers;
	private int storyPoints;
	private boolean isAssigned;

	public Ticket (){}
	
	public Ticket(String jiraId){
		this.setJiraId(jiraId);
	}
	
	public Object getId() {
		return id;
	}
	
	public void setId(Object id) {
		this.id = id;
	}
	
	public String getJiraId(){
		return jiraId;
	}
	
	public void setJiraId(String jiraId){
		this.jiraId = jiraId;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public Date getDateStarted(){
		return dateStarted;
	}
	
	public void setDateStarted(Date dateStarted){
		this.dateStarted = dateStarted;
	}
	
	public Date getDateVerified(){
		return dateVerified;
	}
	
	public void setDateVerified(Date dateVerified){
		this.dateVerified = dateVerified;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}	
	
	public String getPriority(){
		return priority;			
	}
	
	public void setPriority(String priority){
		this.priority = priority;
	}
	
	public Date getDateEnd(){
		return dateEnd;
	}
	
	public void setDateEnd(Date dateEnd){
		this.dateEnd = dateEnd;
	}
	
	public List<String> getDevelopers(){
		return developers;
	}
	
	public void setDevelopers(List<String> developers){
		this.developers = developers;
	}
	
	public int getStoryPoints(){
		return storyPoints;
	}
	
	public void setStoryPoints(int storyPoints){
		this.storyPoints = storyPoints;
	}

	public boolean getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

}
