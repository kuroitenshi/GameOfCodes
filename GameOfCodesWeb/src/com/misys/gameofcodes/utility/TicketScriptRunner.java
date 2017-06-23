package com.misys.gameofcodes.utility;

import java.net.URISyntaxException;
import java.util.List;

import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.service.HouseService;

public class TicketScriptRunner {

	public static void main(String[] args) 
	{
		try {
			FetchTicket ft = new FetchTicket();
			List<House> allHouses = HouseService.fetchHouses();
			
			/*
			 * Ticket and Point updates for all Houses
			 * */
			/*
			for(House chosenHouse: allHouses){
				ft.runRetrievalOfFinishedTickets(chosenHouse.getDomain(), ConstantKeys.VERIFIED_DATE, ConstantKeys.CLOSED_DATE);
			}
			*/
			
			/*
			 * Single House Update
			 * 
			 * */
			ft.runRetrievalOfTickets(ConstantKeys.VERIFIED_DATE_STARTYR, ConstantKeys.CLOSED_DATE_STARTYR, ConstantKeys.FISCALYEAR_END);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
