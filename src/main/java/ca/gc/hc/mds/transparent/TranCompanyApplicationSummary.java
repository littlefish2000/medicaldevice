package ca.gc.hc.mds.transparent;

import java.util.Date;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TranCompanyApplicationSummary {
	public Long id;
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }   	
	
    public Long originalicenceNo;    
    public Long mfgCompanyId;  
    public String c1CompanyName; 
    public Long authCompanyId;
    public String c2CompanyName;   
    public String licenceStatus;
 
    
    public TranCompanyApplicationSummary(Long originalicenceNo,Long mfgCompanyId, String c1CompanyName, Long authCompanyId,
    		String c2CompanyName, String licenceStatus) {
        this.originalicenceNo = originalicenceNo;
        this.mfgCompanyId = mfgCompanyId;
        this.c1CompanyName = c1CompanyName;
        this.authCompanyId = authCompanyId;
        this.c2CompanyName = c2CompanyName;
        this.licenceStatus = licenceStatus; 
        id = (long) 1;
    }  
    
    public static void resetId(List<TranCompanyApplicationSummary> lt) {
    	for (int i=0;i<lt.size();i++) {
    		long index=i+1;
    		lt.get(i).setId(index);    		
    	}
    	
    }
}
