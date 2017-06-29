package com.misys.gameofcodes.utility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.util.concurrent.Promise;
import com.misys.gameofcodes.model.CustomJQL;
import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.JQLConstants;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.service.AdventureService;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.service.TicketService;

public class FetchTicket {
	
	private RestClientUtility restClient;
	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

	public FetchTicket() throws URISyntaxException {
		restClient = new RestClientUtility(15, TimeUnit.MINUTES);

	}

	/* Main Class for fragmented testing */
	public static void main(String[] args) throws IOException {
		/*
		 * Retrieval of FINISHED tickets from a start date to an end date
		 * - ALL DOMAINS
		 * - Start and End Dates are configurable in ConstantKeys class
		 * */
		

		runRetrievalOfTickets(ConstantKeys.VERIFIED_DATE_STARTYR, ConstantKeys.CLOSED_DATE_STARTYR, ConstantKeys.FISCALYEAR_END);
	
			
		/*
		 * Updating Hero Points
		 * */
		getHeroPoints();

		
		/*
		 * Updating House Points
		 * 
		 * */
		//getHousePoints(ConstantKeys.EQUATION_LENDING);
		//getHousePoints(ConstantKeys.ESSENCE_CORE);
		getHousePoints(ConstantKeys.EQUATION_CASHIERDEALS);
		
	}

	/**
	 * Retrieves All Tickets Coming from the designated Start date and End date
	 * and adds them to the specific Sprint
	 * 
	 * @param adventureName
	 * @param domainName
	 * @param startDate
	 * @param endDate
	 */
	public void runRetrievalOfTicketsForSprint(String adventureName, String domainName, String startDate,
			String endDate) {

		switch (domainName) {
		case ConstantKeys.EQUATION_LENDING: {
			// retrieveEQLendingTicketsForISTISNA(adventureName);
			// retrieveEQLendingTicketsForEPA1(adventureName);
		}
			break;

		case ConstantKeys.ESSENCE_CORE: {
			// retrieveEssenceCoreManilaTickets(adventureName);
		}
			break;
		}

	}

	/**
	 * Retrieves Verified and Closed Tickets and Updates the hero points
	 * 
	 * @param domainName
	 * @param verifiedDate
	 * @param closedDate
	 */
	public static void runRetrievalOfTickets(String verifiedDate, String closedDate, String endDate) {

		for(DomainEnumeration domain: DomainEnumeration.values()){

			switch (domain.toString()) {
			case ConstantKeys.EQUATION_LENDING: {
				//retrieveEQLendingTicketsForISTISNA(ConstantKeys.EQLENDING_ISTISNA_ADVENTURE, verifiedDate, closedDate, endDate);
				//retrieveEQLendingTicketsForEPA1(ConstantKeys.EQLENDING_EPA1_ADVENTURE, verifiedDate, closedDate, endDate);
			}
				break;

			case ConstantKeys.ESSENCE_CORE: {
				//retrieveEssenceCoreManilaTickets(ConstantKeys.ESSENCE_CORE_ADVENTURE, verifiedDate, closedDate, endDate);
			}
				break;
				
			case ConstantKeys.EQUATION_CASHIERDEALS: {
				retrieveEQCashierAndDealsTickets(ConstantKeys.EQ_CASHIERDEALS_ADVENTURE, verifiedDate, closedDate, endDate);
			}
				break;	

			}

			//computeTickets(domain.toString());

		}
		
	}

	/**
	 * JQL Query to be used for ticket retrieval
	 * 
	 * @param jqlQuery
	 * @return
	 */
	public SearchResult fetchJQLQuery(String jqlQuery) {

		try {

			Promise<SearchResult> searchJqlPromise = restClient.getJiraRestClient().getSearchClient().searchJql(jqlQuery, 999, null, null);
			
			return searchJqlPromise.claim();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				restClient.getJiraRestClient().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Retrieves Essence Core Manila Tickets based on built JQL
	 */
	private static void retrieveEssenceCoreManilaTickets(String sprintName, String verifiedDate, String closedDate, String endDate) {

		ArrayList<String> projects = new ArrayList<String>();
		projects.add("FBE Core");
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("agutierr");
		developers.add("aclimaco");
		developers.add("jayperez");
		developers.add("jpbautis");
		
		/*Non Active Members*/
		developers.add("edgresma");
		developers.add("rcajigas");
		developers.add("arlozano");

		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		//jql.setVerifiedDate(verifiedDate); // YYYY-MM-DD
		//jql.setClosedDate(closedDate);// YYYY-MM-DD
		//jql.setEndDate(endDate); // YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			String jqlQuery = jql.returnJQLQuery();
			System.out.println("ESSENCE CORE");
			System.out.println("JQL USED: " + jqlQuery + " AND resolved  >= " + verifiedDate + " AND " + "resolved <= " + endDate + " AND status not in(Open) AND type not in (Task, \"Technical task\")");
			//ArrayList<Ticket> tickets = ft.mapIssuesToTickets(ft.fetchJQLQuery(jqlQuery + " AND resolved  >= " + verifiedDate + " AND " + "resolved <= " + endDate + " AND status not in(Open) AND type not in (Task, \"Technical task\")"));
			//ft.addTicketsToSprintInDB(tickets, sprintName, ConstantKeys.ESSENCE_CORE);

		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Retrieves EQ Lending ISTINA Tickets based on built JQL
	 * 
	 */
	/**
	 * @param sprintName
	 * @param verifiedDate
	 * @param closedDate
	 * @param endDate
	 */
	private static void retrieveEQLendingTicketsForISTISNA(String sprintName, String verifiedDate, String closedDate, String endDate) {
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
		status.add("In Progress");
		
		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		jql.setAffectedVersion(affectedVersion);
		jql.setModule(module);
		//jql.setStatus(status);
		//jql.setVerifiedDate(verifiedDate); // YYYY-MM-DD
		//jql.setClosedDate(closedDate);// YYYY-MM-DD
		//jql.setEndDate(endDate); //YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			String jqlQuery = jql.returnJQLQuery();
			System.out.println("EQUATION LENDING - ISTISNA");
			System.out.println("JQL USED: " + jqlQuery + " ((resolved  >= " + verifiedDate + " AND " + "resolved <= " + endDate + ") OR " + "status IN (\"In Progress\"))");
			//ArrayList<Ticket> tickets = ft.mapIssuesToTickets(
				//	ft.fetchJQLQuery(jqlQuery + " ((resolved  >= " + verifiedDate + " AND " + "resolved <= " + endDate + ") OR " + "status IN (\"In Progress\")) " + JQLConstants.EQ_LENDING_ISTISNA_SUMMARY));
			//ft.addTicketsToSprintInDB(tickets, sprintName, ConstantKeys.EQUATION_LENDING);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves EQ Lending EPA1 Tickets based on built JQL
	 */
	private static void retrieveEQLendingTicketsForEPA1(String sprintName, String verifiedDate, String closedDate, String endDate) {
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

		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		//jql.setVerifiedDate(verifiedDate); // YYYY-MM-DD
		//jql.setClosedDate(closedDate);// YYYY-MM-DD
		//jql.setEndDate(endDate); //YYYY-MM-DD
		
		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			String jqlQuery = jql.returnJQLQuery();
			System.out.println("EQUATION LENDING - EPA1");
			System.out.println("JQL USED: " + jqlQuery + " AND ((resolved  >= " + verifiedDate + " AND " + "resolved <= " + endDate + ") OR " + "status IN (\"In Progress\"))");
		
			//ArrayList<Ticket> tickets = ft
					//.mapIssuesToTickets(ft.fetchJQLQuery(jqlQuery + JQLConstants.EQ_LENDING_EPA1_SUMMARY));
			//ft.addTicketsToSprintInDB(tickets, sprintName, ConstantKeys.EQUATION_LENDING);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Retrieves EQ Cashier and Deals Tickets based on built JQL
	 */
	private static void retrieveEQCashierAndDealsTickets(String sprintName, String verifiedDate, String closedDate, String endDate) {
		ArrayList<String> projects = new ArrayList<String>();
		projects.add("EQ");
		projects.add("EQSC");
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("melvchan");
		developers.add("jcortado");
		developers.add("kgangano");
		developers.add("garcial");
		developers.add("lpracull");
		developers.add("kurtsiao");
		developers.add("tanj2");
		developers.add("calongc1");
		developers.add("rjtedoco");

		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
				
		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			String jqlQuery = jql.returnJQLQuery();
			System.out.println("EQUATION CASHIER AND DEALS");
			System.out.println("JQL USED: " + jqlQuery);
		
			ArrayList<Ticket> tickets = ft
					.mapIssuesToTickets(ft.fetchJQLQuery(jqlQuery + JQLConstants.EQ_CASHIER_AND_DEALS_SUMMARY));
			ft.addTicketsToSprintInDB(tickets, sprintName, ConstantKeys.EQUATION_CASHIERDEALS);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.out.println(issue.getKey());

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
					Date createdDate = new SimpleDateFormat("yyyy-MM-dd")
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
					Date verifiedDate = new SimpleDateFormat("yyyy-MM-dd")
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
					closedDate = new SimpleDateFormat("yyyy-MM-dd")
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
			} else {
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

	/**
	 * Adds tickets to ticket collection and creates reference to the adventure
	 * collection
	 * 
	 * @param tickets
	 */
	public void addTicketsToSprintInDB(ArrayList<Ticket> tickets, String sprintName, String house) {

		for (Ticket ticket : tickets) {
			TicketService.addTicket(ticket, house);
			if (!sprintName.isEmpty()) {
				AdventureService.addTicketToAdventure(ticket, sprintName);
			}

		}
	}

	private static void computeTickets(String domainName) {
		getHeroPoints();
		getHousePoints(domainName);
	}

	private static void getHeroPoints() {
		List<Hero> heroes = HeroService.fetchHeroes();
		for (Hero hero : heroes) {
			hero.setStoryPoints(TicketService.getUserTicketSum(hero.getUsername()));
			hero.setStoryPointsMonth(TicketService.getUserTicketSumMonth(hero.getUsername()));
			hero.setLevel(LevelService.fetchHeroLevel(TicketService.getUserTicketSum(hero.getUsername())).getLevel());
			System.out.println(EncoderUtility.toJSON(hero));
			HeroService.updateHeroPoints(hero);
		}
	}

	private static void getHousePoints(String domainName) {
		House house = new House();
		house.setDomain(domainName);
		house.setStoryPoints(HouseService.getHousePoints(domainName));
		house.setLevel(LevelService.fetchHouseLevel(HouseService.getHousePoints(domainName)).getLevel());
		HouseService.updateHousePoints(house);
	}

}
