package ca.gc.hc.mds.domain;
import java.util.Calendar;

import javax.persistence.Column;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = RenewalPK.class, table = "RENEWAL",versionField = "", schema = "MDSDB")
public class Renewal {
	
    @Column(name = "RECEIPT_DT", nullable = false)
    private Calendar receiptDt;
    
}
