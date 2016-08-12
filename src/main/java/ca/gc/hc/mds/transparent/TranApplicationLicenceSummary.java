package ca.gc.hc.mds.transparent;

import java.util.Date;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.reference.ApplicationType;

@RooJavaBean
@RooToString
public class TranApplicationLicenceSummary {
	public Long id;
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }   	
	
    
    public TranApplicationLicenceSummary(Long applicationId, ApplicationType applicationType,String appldeviceStatus
    		, Date statusDate,String licenceName,String evaluationRequired,Date licenceDate ) {
    	
    	this.applicationId = applicationId;
    	this.applicationType = applicationType;
    	this.appldeviceStatus = appldeviceStatus;
    	this.statusDate = statusDate;
    	this.licenceName = licenceName;
    	this.evaluationRequired = evaluationRequired;
    	this.licenceDate = licenceDate;
        id = (long) 1;
    }  
    
    public Long applicationId;
    public ApplicationType applicationType;
    public String appldeviceStatus;
    public Date statusDate;
    public String licenceName;
    public String evaluationRequired;
    public Date licenceDate;
    
    
    public static void resetId(List<TranApplicationLicenceSummary> lt) {
    	for (int i=0;i<lt.size();i++) {
    		long index=i+1;
    		lt.get(i).setId(index);    		
    	}
    	
    }
}
