package ca.gc.hc.mds.domain;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = RenLicenceInfoPK.class, table = "REN_LICENCE_INFO",versionField = ""
,finders = { "findRenLicenceInfoesByLicenceNameEquals" },schema = "MDSDB")
public class RenLicenceInfo {
	
    /**
     */
    @Column(name = "LICENCE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    private String licenceName;	
    
    @Column(name = "DATE_ISSUED", nullable = false)
    private Date dateIssued;    
    
    @Column(name = "RECEIPT_DT", nullable = false)
    private Date receiptDt;    
	
    @Column(name = "POSTED_DT", nullable = false)
    private Date postDt;    
	
    @Column(name = "INVOICE_DT", nullable = false)
    private Date invoiceDt;    
	
}
