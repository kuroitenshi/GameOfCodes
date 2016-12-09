package com.misys.gameofcodes.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.misys.gameofcodes.dao.TicketsDAOImpl;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.service.TicketService;

public class FetchTicket {
	private AsynchronousJiraRestClientFactory factory;
	private URI jiraServerUri;
	private JiraRestClient restClient;
	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
	public FetchTicket() throws URISyntaxException {
		factory = new AsynchronousJiraRestClientFactory();
		jiraServerUri = new URI("http://almtools/jira/");
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException, JSONException {
		FetchTicket ft = new FetchTicket();
		//ArrayList<Ticket> tickets = ft.fetchTicket(ft.fetchJQLQuery("test"));
		//ft.getTickets(tickets);
		ft.computeTickets();
	}
	
	private void getTickets(ArrayList<Ticket> tickets) {
		TicketsDAOImpl ticketsDAO = new TicketsDAOImpl();
		for (Ticket ticket: tickets) {		
			TicketService.addTicket(ticket);
		}
	}
	private void computeTickets() {
		List<Hero> heroes = HeroService.fetchHeroes();
		for (Hero hero: heroes) {
			hero.setStoryPoints(TicketService.getUserTicketSum(hero.getUsername()));
			hero.setLevel(LevelService.fetchHeroLevel(TicketService.getUserTicketSum(hero.getUsername())).getLevel());
			HeroService.updateHeroPoints(hero);
		}
	}

	private SearchResult fetchJQLQuery(String jqlQuery) throws IOException {
		try {
			restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "edgresma", "#10@MIsys2");
			//return	restClient.getSearchClient().searchJql("assignee = abianb1 and status = open").claim();
			//return	restClient.getSearchClient().searchJql("developers=edgresma and status = closed").claim();
			return	restClient.getSearchClient().searchJql("project in (\"Universal Banking\", \"Universal Banking Scrum\") AND Developers in (agutierr, edgresma, rcajigas, arlozano, yasisr1, fegarcia, jayperez, aclimaco, jpbautis) AND status in (Closed, Built, Verified) AND (Verified>=2016-06-01 OR \"Closed Date\" >= 2016-06-01)", -1, 0, new HashSet<String>()).claim();		
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			restClient.close();
		}
		return null;
	}
	
	private ArrayList<Ticket> fetchTicket(SearchResult searchResult) throws JSONException {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Iterator iterator = searchResult.getIssues().iterator();
		while (iterator.hasNext()) {
			Issue issue = (Issue) iterator.next();
			Ticket ticket = new Ticket();
			// Jira ID
			if (issue.getKey() != null) {
				ticket.setJiraId(issue.getKey());
			}
			// Title
			if (issue.getSummary() != null) {
				ticket.setTitle(issue.getSummary());
			} else {
				ticket.setTitle("");
			}
			// Description
			if (issue.getDescription() != null) {
				ticket.setDescription(issue.getDescription());
			} else {
				ticket.setDescription("");
			}
			// Start Date
			if (issue.getCreationDate() != null){
				try {
					Date createdDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(issue.getCreationDate().toDateTime().toString());
					ticket.setDateStarted(createdDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				ticket.setDateStarted(new Date(0));
			}
			// Verified Date
			if (issue.getField(ConstantKeys.CUSTFIELD_VERIFIED_DATE).getValue() != null) {
				
				try {
					Date verifiedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(issue.getField(ConstantKeys.CUSTFIELD_VERIFIED_DATE).getValue().toString());
					ticket.setDateVerified(verifiedDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				ticket.setDateVerified(new Date(0));
			}
			// Status
			if (issue.getStatus() != null) {
				ticket.setStatus(issue.getStatus().getName());
			} else {
				ticket.setStatus("");
			}
			// Severity
			if (issue.getField(ConstantKeys.CUSTFIELD_SEVERITY) != null) {
				JSONObject severity = (JSONObject) issue.getField(ConstantKeys.CUSTFIELD_SEVERITY).getValue();
				ticket.setSeverity(severity.getString("value"));
			} else {
				ticket.setSeverity("");
			}
			// Priority
			if (issue.getPriority() != null) {
				ticket.setPriority(issue.getPriority().getName());
			} else {
				ticket.setPriority("");
			}
			// Closed Date
			if (issue.getField(ConstantKeys.CUSTFIELD_CLOSED_DATE).getValue() != null) {
				Date closedDate;
				try {
					closedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(issue.getField(ConstantKeys.CUSTFIELD_CLOSED_DATE).getValue().toString());
					ticket.setDateEnd(closedDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				ticket.setDateEnd(new Date(0));
			}
			// Developers
			JSONArray developers = (JSONArray) issue.getField(ConstantKeys.CUSTFIELD_DEVELOPERS).getValue();
			if(developers != null) {
				List<String> devList = new ArrayList<String>();
			    for (int i = 0; i < developers.length(); i++) {
			    	try {
						devList.add(developers.getJSONObject(i).get("key").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
			    }
			    ticket.setDevelopers(devList);
			}
			// Story Points
			if (issue.getField(ConstantKeys.CUSTFIELD_STORY_POINTS).getValue() != null) {
				ticket.setStoryPoints((int) Double.parseDouble(issue.getField(ConstantKeys.CUSTFIELD_STORY_POINTS).getValue().toString()));
			} else {
				ticket.setStoryPoints(0);
			}
			tickets.add(ticket);
		}
		return tickets;
	}

}
