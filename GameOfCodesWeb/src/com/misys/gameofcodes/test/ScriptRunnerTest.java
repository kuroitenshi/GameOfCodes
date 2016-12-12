package com.misys.gameofcodes.test;

import java.net.URISyntaxException;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;
import com.misys.gameofcodes.model.Level;
import com.misys.gameofcodes.service.HeroService;
import com.misys.gameofcodes.service.HouseService;
import com.misys.gameofcodes.service.LevelService;
import com.misys.gameofcodes.utility.EncoderUtility;
import com.misys.gameofcodes.utility.FetchTicket;

public class ScriptRunnerTest {

	public static void main(String[] args) {
			try {
				FetchTicket ft = new FetchTicket();
				ft.runScript();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
