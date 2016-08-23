package ca.gc.hc.mds.web;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.gc.hc.mds.domain.Application;

@RequestMapping("/ajax/applications")
@Controller
@Transactional
public class AjaxApplicationController {	
	
	@RequestMapping(value = "/perform_app_desc_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String performApplicationDescriptionUpdate( @RequestParam(value = "app_id", required = true) Long applicationId, @RequestParam(value = "updated_app_desc", required = true) String updatedDescription){
					
		Application application = Application.findApplication(applicationId);
		application.setApplicationDesc(updatedDescription);
						
		EntityManager entityManager =Application.entityManager();
		application = entityManager.merge(application);
		entityManager.flush();
				
		//get updated value from Database
		String response = application.getApplicationDesc();	
		
		return response;		
	}
	
	@RequestMapping(value = "/cancel_app_desc_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String cancelApplicationDescriptionUpdate( @RequestParam(value = "app_id", required = true) Long applicationId){
				
		Application application = Application.findApplication(applicationId);
		
		String applicationDescription = application.getApplicationDesc();				
		
		return applicationDescription;		
	}
	
	

}
