package ca.gc.hc.mds.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.gc.hc.mds.domain.ApplAmendReasonPK;
import ca.gc.hc.mds.domain.ApplAmendmentReason;
import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.LicIntendedIndicationUse;

@RequestMapping("/ajax/applications")
@Controller
@Transactional
public class AjaxApplicationController {	
	
	@RequestMapping(value = "/perform_app_desc_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String performApplicationInfoUpdate( @RequestParam(value = "app_id", required = true) Long applicationId,
			@RequestParam(value = "updated_value", required = true) String updatedValue,
			@RequestParam(value = "fieldname", required = true) String fieldname){
					
		Application application = Application.findApplication(applicationId);
		if (fieldname.equalsIgnoreCase("APPDESC")){
			application.setApplicationDesc(updatedValue);
		}
		else if (fieldname.equalsIgnoreCase("APPCOMM")){
			application.setApplicationComments(updatedValue);
		}
		else if (fieldname.equalsIgnoreCase("AMENDREASON")){	
			ApplAmendmentReason amendmentReason = application.getAmendmentReason();
			if (amendmentReason == null){				
				amendmentReason = new ApplAmendmentReason();
				amendmentReason.setApplicationId(applicationId);
				application.setAmendmentReason(amendmentReason);
			}		
			if (updatedValue!=""){
				amendmentReason.setReasonCd(updatedValue);	
			}
			else{ // delete the existing record
				application.getAmendmentReason().remove();
				application.getAmendmentReason().flush();
				application.setAmendmentReason(null);
			}
		}
		else if (fieldname.equalsIgnoreCase("INTINDIC")){
			if (application.getIntendedIndication() != null){
				if (updatedValue!=""){
					application.getIntendedIndication().setIntendedIndicationUse(updatedValue);		
				}
				else{ // delete the existing record
					application.getIntendedIndication().remove();
					application.getIntendedIndication().flush();
					application.setIntendedIndication(null);
				}
					
			}
			else{
				LicIntendedIndicationUse licIndication = new LicIntendedIndicationUse();
				//TODO licIndication.setEntryDt(today);
				//TODO licIndication.setNovellUserId(novellUserId);
				//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				licIndication.setEntryDt(cal.getTime());
				licIndication.setNovellUserId("eg");
				licIndication.setIntendedIndicationUse(updatedValue);
				licIndication.setApplication(application);
				application.setIntendedIndication(licIndication);
			}
				
		}
		
		EntityManager entityManager =Application.entityManager();
		application = entityManager.merge(application);
		entityManager.flush();
		
		String response = null;
		//get updated value from Database
		if (fieldname.equalsIgnoreCase("APPDESC")){
			response = application.getApplicationDesc();	
		}
		else  if (fieldname.equalsIgnoreCase("APPCOMM")){
			response = application.getApplicationComments();
		}else if (fieldname.equalsIgnoreCase("AMENDREASON")){
			if(application.getAmendmentReason() != null){
				response = application.getAmendmentReason().getReasonCd();	
			}
		}else if (fieldname.equalsIgnoreCase("INTINDIC")){
			if(application.getIntendedIndication() != null){
				response = application.getIntendedIndication().getIntendedIndicationUse();	
			}
		}
		
		return response;		
	}
	
	@RequestMapping(value = "/cancel_app_desc_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String cancelApplicationInfoUpdate( @RequestParam(value = "app_id", required = true) Long applicationId,
			@RequestParam(value = "fieldname", required = true) String fieldname){
				
		Application application = Application.findApplication(applicationId);
		
		if (fieldname.equalsIgnoreCase("APPDESC")){
			String applicationDescription = application.getApplicationDesc();
			return applicationDescription;
		}
		else if (fieldname.equalsIgnoreCase("APPCOMM")){
			String applicationComments = application.getApplicationComments();
			return applicationComments;
		}else if (fieldname.equalsIgnoreCase("AMENDREASON")){
			String amendReason = application.getAmendmentReason().getReasonCd();
			return amendReason;
		}
		else if (fieldname.equalsIgnoreCase("INTINDIC")){
			String indicationUse = application.getIntendedIndication().getIntendedIndicationUse();
			return indicationUse;
		}
		return null;
				
	}
	
	
	
	
}
