package com.misys.gameofcodes.model;

public class JQLConstants {

	public static final String EQ_LENDING_EPA1_SUMMARY = " AND summary ~ EQ-QA AND (summary ~ EPA1E430304 OR summary ~ EPA1E430305 OR summary ~ EPA1E43305REL OR summary ~ EPA1E43306REL OR summary ~ EPA1E430305REL OR summary ~ EPA1E430306REL OR summary ~ EPA1E43307REL OR summary ~ E43307DEFECTRETEST) ";
	public static final String EQ_LENDING_ISTISNA_SUMMARY = " AND summary ~ EQ-QA AND (summary ~ E430302 OR summary ~ IST OR summary ~ E430300 OR summary ~ E430301 OR summary ~ E430303 OR summary ~ E430304) ";
	public static final String EQ_LENDING_BOC_SUMMARY = " AND (\"Closed Date\"  >= \"2017/06/01\" OR " + "\"Closed Date\" = EMPTY) AND TYPE = Defect AND labels = BCYPNA_Upg AND labels = EQDevInternal AND (fixVersion != \"EQ 4.3.3.07\" OR fixVersion = EMPTY) ";
	public static final String EQ_CASHIER_AND_DEALS_SUMMARY = " AND labels in (EQ-IFRS9, EQ-OPICS) ORDER BY status DESC ";
}
