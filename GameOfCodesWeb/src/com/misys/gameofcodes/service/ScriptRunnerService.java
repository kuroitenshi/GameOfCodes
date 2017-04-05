package com.misys.gameofcodes.service;

import java.net.URISyntaxException;

import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.utility.FetchTicket;

public class ScriptRunnerService {

	private ScriptRunnerService() { }
	private static ScriptRunnerService scriptRunnerService;
	public static ScriptRunnerService getTicketService(){
		if (scriptRunnerService == null){
			scriptRunnerService = new ScriptRunnerService();
		}
		return scriptRunnerService;
	}
	
	public void runScripts() {
		try {
			FetchTicket ft = new FetchTicket();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
