package ca.gc.hc.mds.transparent;

import java.util.Date;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TranDeviceSummaryStatus {
	public Long id;
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }   	
	
    public Long originalicenceNo;    
    public String appldevStatus;    
    public Date licencestatusDate;	    
    public String descr;
 
    
    public TranDeviceSummaryStatus(Long originalicenceNo, String appldevStatus, Date licencestatusDate,String descr) {
        this.originalicenceNo = originalicenceNo;
        this.appldevStatus = appldevStatus;
        this.licencestatusDate = licencestatusDate;
        this.descr = descr; 
        id = (long) 1;
    }  
    
    public static void resetId(List<TranDeviceSummaryStatus> lt) {
    	for (int i=0;i<lt.size();i++) {
    		long index=i+1;
    		lt.get(i).setId(index);    		
    	}
    	
    }
}
