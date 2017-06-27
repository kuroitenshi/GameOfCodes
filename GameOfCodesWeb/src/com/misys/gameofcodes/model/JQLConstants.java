package com.misys.gameofcodes.model;

public class JQLConstants {

	public static final String EQ_LENDING_EPA1_SUMMARY = " AND summary ~ EQ-QA AND (summary ~ EPA1E430304 OR summary ~ EPA1E430305) ";
	public static final String EQ_LENDING_ISTISNA_SUMMARY = " AND summary ~ EQ-QA AND (summary ~ E430302 OR summary ~ IST OR summary ~ E430300 OR summary ~ E430301 OR summary ~ E430303 OR summary ~ E430304) ";
	public static final String EQ_CASHIER_AND_DEALS_SUMMARY = " AND labels in (EQ-IFRS9, EQ-OPICS) ORDER BY status DESC ";
}
