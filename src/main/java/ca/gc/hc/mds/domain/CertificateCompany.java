package ca.gc.hc.mds.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB",identifierType = CertificateCompanyPK.class, table = "CERTIFICATE_COMPANY")
public class CertificateCompany {
	
    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;
    
    /**
     */
    @NotNull
    @Column(name = "RECEIPT_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date receiptDate;   
    
    /**
     */
    @Column(name = "ENTRY_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate; 
    
	@Column(name="NAME_RATIONAL", columnDefinition = "char", nullable=false, length=280)	
	private String nameRational;    
}
