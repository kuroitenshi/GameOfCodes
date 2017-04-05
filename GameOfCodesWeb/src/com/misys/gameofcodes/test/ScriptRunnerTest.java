package com.misys.gameofcodes.test;

import java.net.URISyntaxException;

import com.misys.gameofcodes.utility.FetchTicket;
import com.misys.gameofcodes.utility.SprintManager;

public class ScriptRunnerTest {

	public static void main(String[] args) {
			try {
				FetchTicket ft = new FetchTicket();
				SprintManager sprint = new SprintManager();				
				ft.runRetrievalOfTickets(sprint.addNewSprint());
				
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
