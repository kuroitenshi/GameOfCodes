package com.misys.gameofcodes.utility;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class EncoderUtility {
	public static String toJSON(Object object) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static String getEmptyIfNull(String input ) {
		try {
			return input;
		} catch (NullPointerException e) {
			return "";
		}
	}
	public static Integer getZeroIfNull(String input ) {
		try {
			return Integer.parseInt(input);
			} catch (NullPointerException e) {
			return 0;
		}	
		
	}
	
}
