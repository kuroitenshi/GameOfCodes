package com.misys.gameofcodes.utility;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
import com.misys.gameofcodes.model.CustomJQL;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.JQLConstants;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
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

	public static void main(String[] args) throws IOException {
		computeEQLendingTicketsForISTISNA();
		computeEQLendingTicketsForEPA1();
	}

	public void computeEssenceCoreTickets() {
		ArrayList<String> projects = new ArrayList<String>();
		projects.add("FBE Core");
		projects.add("Universal Banking Scrum");
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("agutierr");
		developers.add("edgresma");
		developers.add("rcajigas");
		developers.add("arlozano");
		developers.add("yasisr1");
		developers.add("fegarcia");
		developers.add("aclimaco");
		developers.add("jayperez");
		developers.add("jpbautis");
		ArrayList<String> status = new ArrayList<String>();
		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		jql.setVerifiedDate("2016-06-01"); // YYYY-MM-DD
		jql.setClosedDate("2016-06-01");// YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			System.out.println(jql.returnJQLQuery());
			ft.fetchJQLQuery(jql.returnJQLQuery()); // ft.getTickets(tickets);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ft.computeTickets();

	}

	public static void computeEQLendingTicketsForISTISNA() {
		ArrayList<String> projects = new ArrayList<String>();
		projects.add("EQ");
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("domingw2");
		developers.add("rogedian");
		developers.add("mangunf1");
		developers.add("marquel1");
		developers.add("dalistal");
		developers.add("blandich");
		developers.add("jmarque2");
		developers.add("jclemen2");
		developers.add("jpardill");
		developers.add("gladysyu");
		developers.add("jcristob");
		developers.add("ccalamba");
		developers.add("bvictori");
		ArrayList<String> affectedVersion = new ArrayList<String>();
		affectedVersion.add("EMPTY");
		affectedVersion.add("EQ 4.3.3.02");
		affectedVersion.add("EQ 4.3.3.01");
		affectedVersion.add("EQ 4.3.3.03");
		affectedVersion.add("EQ 4.3.3.00");
		affectedVersion.add("EQ 4.3.3.04");
		ArrayList<String> module = new ArrayList<String>();
		module.add("EQ - Lending");
		ArrayList<String> status = new ArrayList<String>();
		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		jql.setAffectedVersion(affectedVersion);
		jql.setModule(module);
		jql.setVerifiedDate("2016-06-01"); // YYYY-MM-DD
		jql.setClosedDate("2016-06-01");// YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			System.out.println(jql.returnJQLQuery() + JQLConstants.EQ_LENDING_ISTISNA_SUMMARY);
			// ft.fetchJQLQuery(jql.returnJQLQuery()); //
			// ft.getTickets(tickets);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ft.computeTickets();

	}

	public static void computeEQLendingTicketsForEPA1() {
		ArrayList<String> projects = new ArrayList<String>();
		projects.add("EQ");
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("domingw2");
		developers.add("rogedian");
		developers.add("mangunf1");
		developers.add("marquel1");
		developers.add("dalistal");
		developers.add("blandich");
		developers.add("jmarque2");
		developers.add("jclemen2");
		developers.add("jpardill");
		developers.add("gladysyu");
		developers.add("jcristob");
		developers.add("ccalamba");
		developers.add("bvictori");
		ArrayList<String> status = new ArrayList<String>();
		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		jql.setVerifiedDate("2016-06-01"); // YYYY-MM-DD
		jql.setClosedDate("2016-06-01");// YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			System.out.println(jql.returnJQLQuery() + JQLConstants.EQ_LENDING_EPA1_SUMMARY);
			// ft.fetchJQLQuery(jql.returnJQLQuery()); //
			// ft.getTickets(tickets);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ft.computeTickets();

	}

	public void runScript() {
		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ArrayList<Ticket> tickets = ft.mapIssuesToTickets(ft.fetchJQLQuery("test"));
		ft.addTicketsToDB(tickets);
		ft.computeTickets();
	}

	/**
	 * JQL Query to be used for ticket retrieval
	 * 
	 * @param jqlQuery
	 * @return
	 */
	public SearchResult fetchJQLQuery(String jqlQuery) {
		try {
			restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, "jpbautis", "icecreamMEL28:))");
			Promise<SearchResult> searchJqlPromise = restClient.getSearchClient().searchJql(jqlQuery, 999, null, null);

			return searchJqlPromise.claim();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				restClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Issues retrieved should be mapped to the respective GOC Ticket Object
	 * 
	 * @param searchResult
	 * @return
	 */
	public ArrayList<Ticket> mapIssuesToTickets(SearchResult searchResult) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Iterator<Issue> iterator = searchResult.getIssues().iterator();
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
			if (issue.getCreationDate() != null) {
				try {
					Date createdDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
							.parse(issue.getCreationDate().toDateTime().toString());
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
					Date verifiedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
							.parse(issue.getField(ConstantKeys.CUSTFIELD_VERIFIED_DATE).getValue().toString());
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
					closedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
							.parse(issue.getField(ConstantKeys.CUSTFIELD_CLOSED_DATE).getValue().toString());
					ticket.setDateEnd(closedDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				ticket.setDateEnd(new Date(0));
			}
			// Developers
			JSONArray developers = (JSONArray) issue.getField(ConstantKeys.CUSTFIELD_DEVELOPERS).getValue();
			if (developers != null) {
				List<String> devList = new ArrayList<String>();
				for (int i = 0; i < developers.length(); i++) {
					try {
						devList.add(developers.getJSONObject(i).get("key").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				ticket.setDevelopers(devList);
				ticket.setIsAssigned(true);
			}else{
				ticket.setIsAssigned(false);
			}
			// Story Points
			if (issue.getField(ConstantKeys.CUSTFIELD_STORY_POINTS).getValue() != null) {
				ticket.setStoryPoints((int) Double
						.parseDouble(issue.getField(ConstantKeys.CUSTFIELD_STORY_POINTS).getValue().toString()));
			} else {
				ticket.setStoryPoints(0);
			}
			tickets.add(ticket);
			
		}
		return tickets;
	}

	public void addTicketsToDB(ArrayList<Ticket> tickets) {
		//fetch ticket by JiraID
		//If exists
		for (Ticket ticket : tickets) {
			TicketService.addTicket(ticket);
		}
	}

	private void computeTickets() {
		getHeroPoints();
		getHousePoints();
	}

	private void getHeroPoints() {
		List<Hero> heroes = HeroService.fetchHeroes();
		for (Hero hero : heroes) {
			hero.setStoryPoints(TicketService.getUserTicketSum(hero.getUsername()));
			hero.setStoryPointsMonth(TicketService.getUserTicketSumMonth(hero.getUsername()));
			hero.setLevel(LevelService.fetchHeroLevel(TicketService.getUserTicketSum(hero.getUsername())).getLevel());
			System.out.println(EncoderUtility.toJSON(hero));
			HeroService.updateHeroPoints(hero);
		}
	}

	private void getHousePoints() {
		House house = new House();
		house.setStoryPoints(HouseService.getHousePoints("Essence Core"));
		house.setLevel(LevelService.fetchHouseLevel(HouseService.getHousePoints("Essence Core")).getLevel());
		HouseService.updateHousePoints(house);
	}

}
