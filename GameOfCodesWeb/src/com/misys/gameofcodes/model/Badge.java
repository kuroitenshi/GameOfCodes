package com.misys.gameofcodes.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.sun.javafx.collections.MappingChange.Map;

@XmlRootElement
public class Badge {
	
	private String id;
	
	private String badgename;
	private String description;
	private String badgeType;
	private String imageId;
	
	public Badge() {};
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBadgename() {
		return badgename;
	}
	public void setBadgename(String badgename) {
		this.badgename = badgename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBadgeType() {
		return badgeType;
	}
	public void setBadgeType(String badgeType) {
		this.badgeType = badgeType;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	
	

	
}
