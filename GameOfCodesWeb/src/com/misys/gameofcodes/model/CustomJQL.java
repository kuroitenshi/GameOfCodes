package com.misys.gameofcodes.model;

import java.util.ArrayList;

public class CustomJQL {

	private ArrayList<String> projects;
	private ArrayList<String> developers;
	private ArrayList<String> status;
	private ArrayList<String> affectedVersion;
	private ArrayList<String> module;
	private int storyPoints;
	private String priority;
	private String verifiedDate;
	private String closedDate;
	private String endDate;
	
	private StringBuilder JQLbuilder;

	public CustomJQL() {
		JQLbuilder = new StringBuilder();
		storyPoints = 0;
		priority = "";
		verifiedDate = "";
		closedDate = "";
		endDate = "";
	}

	public ArrayList<String> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<String> projects) {
		this.projects = projects;
	}

	public ArrayList<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(ArrayList<String> developers) {
		this.developers = developers;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(String verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	public ArrayList<String> getAffectedVersion() {
		return affectedVersion;
	}

	public ArrayList<String> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}

	public void setAffectedVersion(ArrayList<String> affectedVersion) {
		this.affectedVersion= affectedVersion;
	}
	
	public ArrayList<String> getModule() {
		return module;
	}

	public void setModule(ArrayList<String> module) {
		this.module = module;
	}


	public String returnJQLQuery() {

		String result = null;
		
		if (addedProjects() && !isLast(0)) {
			JQLbuilder.append(" AND ");
		}
		if (addedDevelopers() && !isLast(1)) {
			JQLbuilder.append(" AND ");
		}
		if (addedStatus() && !isLast(2)) {
			JQLbuilder.append(" AND ");
		}
		if(addedAffectedVersion() && !isLast(2))
		{
			JQLbuilder.append(" AND ");
		}
		if(addedModule() && !isLast(2))
		{
			JQLbuilder.append(" AND ");
		}
		if (storyPoints != 0 ) {
			JQLbuilder.append("Story Points = " + storyPoints);
			if(!isLast(3)){
				JQLbuilder.append(" AND ");
			}
			
		}
		if (!priority.isEmpty()) {
			JQLbuilder.append("priority = " + priority);
			if(!isLast(4)){
				JQLbuilder.append(" AND ");
			}			
		}
		
		if (!verifiedDate.isEmpty()) {
			JQLbuilder.append("(Verified >= " + verifiedDate);
			if(!isLast(5)){
				JQLbuilder.append(" OR ");
			}			
		}
		
		if (closedDate != "" ) {
			JQLbuilder.append("\"Closed Date\" >= " + closedDate +")");	
			if(!isLast(6)){
				JQLbuilder.append(" AND ");
			}	
		}
		
		if(!endDate.isEmpty()){
			JQLbuilder.append("(Verified <= " + endDate + " OR " + "\"Closed Date\" <= " + endDate + ")");
		}
		result = JQLbuilder.toString();
		
		this.clearfieldContents();
		
		return result;

	}

	private boolean addedProjects() {
		if (projects != null) {
			JQLbuilder.append("project IN (");
			for (int i = 0; i < projects.size(); i++) {
				JQLbuilder.append("\"" + projects.get(i) + "\"");
				if (i != projects.size() - 1) {
					JQLbuilder.append(", ");
				}
			}
			JQLbuilder.append(")");

			return true;
		}
		return false;

	}

	private boolean addedDevelopers() {
		if (developers != null) {
			JQLbuilder.append("Developers IN (");
			for (int i = 0; i < developers.size(); i++) {
				JQLbuilder.append(developers.get(i));
				if (i != developers.size()-1) {
					JQLbuilder.append(", ");
				}
			}
			JQLbuilder.append(" )");

			return true;
		}
		return false;

	}

	private boolean addedStatus() {
		if (status != null) {
			JQLbuilder.append("status IN (");
			for (int i = 0; i < status.size(); i++) {
				JQLbuilder.append("\"" + status.get(i) + "\"");
				if (i != status.size()-1) {
					JQLbuilder.append(", ");
				}
			}
			JQLbuilder.append(" ) ");

			return true;
		}
		return false;

	}
	
	private boolean addedAffectedVersion() {
		if (affectedVersion != null) {
			JQLbuilder.append("affectedVersion IN (");
			for (int i = 0; i < affectedVersion.size(); i++) {
				if(affectedVersion.get(i).equals("EMPTY")) {
					JQLbuilder.append(affectedVersion.get(i));
				}
				else {
					JQLbuilder.append("\"" + affectedVersion.get(i) + "\"");
				}
				if (i != affectedVersion.size() - 1) {
					JQLbuilder.append(", ");
				}
			}
			JQLbuilder.append(") ");

			return true;
		}
		return false;

	}
	
	private boolean addedModule() {
		if (module != null) {
			JQLbuilder.append("module IN (");
			for (int i = 0; i < module.size(); i++) {
				JQLbuilder.append("\"" + module.get(i) + "\"");
				if (i != module.size() - 1) {
					JQLbuilder.append(", ");
				}
			}
			JQLbuilder.append(") ");

			return true;
		}
		return false;

	}

	private boolean isLast(int iteration) {
		boolean isLast;
		switch (iteration) {
		case 0: {
			isLast = (developers == null && status == null && storyPoints == 0 && priority.isEmpty() && verifiedDate.isEmpty() && closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 1: {
			isLast = (status == null && storyPoints == 0 && priority.isEmpty() && verifiedDate.isEmpty() && closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 2: {
			isLast = (storyPoints == 0 && priority.isEmpty() && verifiedDate.isEmpty() && closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 3: {
			isLast = (priority.isEmpty() && verifiedDate.isEmpty() && closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 4: {
			isLast = (verifiedDate.isEmpty() && closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 5: {
			isLast = (closedDate.isEmpty() && endDate.isEmpty());
			break;
		}
		case 6:{
			isLast = (endDate.isEmpty());
			break;
		}
		default: {
			return true;
		}
		}
		return isLast;
	}
	
	private void clearfieldContents(){
		
		if(projects != null){
			projects.clear();
		}
		if(developers != null){
			developers.clear();
		}
		if(status != null){
			status.clear();	
		}
		if(affectedVersion != null){
			affectedVersion.clear();	
		}
		if(module != null){
			module.clear();
		}	
	
		storyPoints = 0;
		priority = "";
		verifiedDate = "";
		closedDate = "";
		JQLbuilder = new StringBuilder();
	}
}
