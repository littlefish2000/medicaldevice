package ca.gc.hc.mds.transparent;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TranCompanyFinance {
	public Long id;
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    } 
    
	public static void resetId(List<TranCompanyFinance> cfList) {
		 long count = 0;
		
		 for (TranCompanyFinance cf:cfList) {
			 cf.setId(++count);    		
	    	    		
		 }
	    	
	}   
	
	public Long companyId;
	public Long billToId;
	public String companyName;
	public String contactName;
	public String e_MAIL;
	
	
    public TranCompanyFinance(Long companyId,Long billToId, String companyName,String contactName, String e_MAIL) {
        this.companyId = companyId;
        this.billToId = billToId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.e_MAIL = e_MAIL;
        id = (long) 1;
    }	

}
