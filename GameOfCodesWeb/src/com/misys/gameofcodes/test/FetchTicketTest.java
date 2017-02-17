package com.misys.gameofcodes.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.misys.gameofcodes.model.CustomJQL;
import com.misys.gameofcodes.model.Ticket;
import com.misys.gameofcodes.utility.FetchTicket;

public class FetchTicketTest {
	public static void main(String[] args) throws IOException {

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
		status.add("Closed");
		status.add("Built");
		status.add("Verified");
		CustomJQL jql = new CustomJQL();
		jql.setProjects(projects);
		jql.setDevelopers(developers);
		jql.setStatus(status);
		jql.setVerifiedDate("2016-06-01"); // YYYY-MM-DD
		jql.setClosedDate("2016-06-01");// YYYY-MM-DD

		FetchTicket ft = null;
		try {
			ft = new FetchTicket();
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			tickets = ft.mapIssuesToTickets(ft.fetchJQLQuery(jql.returnJQLQuery())); // ft.getTickets(tickets);
			ft.addTicketsToDB(tickets);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// ft.computeTickets();

	}
}
