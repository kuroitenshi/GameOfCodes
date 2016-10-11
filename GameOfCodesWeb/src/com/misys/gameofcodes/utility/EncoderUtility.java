package com.misys.gameofcodes.utility;

public class EncoderUtility {

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
