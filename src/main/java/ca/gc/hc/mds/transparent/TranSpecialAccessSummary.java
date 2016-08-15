package ca.gc.hc.mds.transparent;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TranSpecialAccessSummary {
	private Long id;
	
	private Long specialAccessID;
	private Date requestDate;
	private Date actionDate;
	private String actionTaken;
	
	private String deviceIdentifier;
	
	public TranSpecialAccessSummary( Long specialAccessID, Date requestDate, Date actionDate, String actionTaken, String deviceIdentifier){
		this.specialAccessID=specialAccessID;
		this.requestDate=requestDate;
		this.actionDate=actionDate;
		this.actionTaken=actionTaken;		
		this.deviceIdentifier=deviceIdentifier;
		
		
	}
	
	 public static void resetId(List<TranSpecialAccessSummary> summaryList) {
		 long count = 0;
		
		 for (TranSpecialAccessSummary summary:summaryList) {
	    		
	    	summary.setId(++count);    		
		 }
	    	
	}
	 
	public static void updateActionTaken(List<TranSpecialAccessSummary> summaryList) {
		
		Hashtable<String, String> actions = new Hashtable<String, String>();		
		actions.put("Y", "Yes");
		actions.put("N", "No");
		actions.put("P", "Pending");
		actions.put("W", "Withdrawl");
		actions.put("NULL", "Unknown");	
		
		
		 for (TranSpecialAccessSummary summary:summaryList) {
			 
			 if (summary.actionTaken == null || summary.actionTaken.trim().equals("")){
				 summary.actionTaken = "NULL";
			 }
	    		
	    	summary.actionTaken = actions.get(summary.actionTaken.trim().toUpperCase()) ;	
		 }
	    	
	}
		

}
