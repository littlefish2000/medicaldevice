package ca.gc.hc.mds.domain;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB",table = "CERTIFICATE",identifierColumn="ORIG_CERTIFICATE_ID", identifierField = "origcertificateId", identifierType = String.class)
public class Certificate {

	@PrePersist
	private void ensureId(){
	    this.setOrigcertificateId(UUID.randomUUID().toString());
	}
	
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORIG_CERTIFICATE_ID", columnDefinition = "char")
    private String origcertificateId;
    
	@Column(name = "CERTIFICATE_ID", columnDefinition = "char")
	private String certificateId;  	
	
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
    
    
	@Column(name = "SYSTEM_USER_ID", columnDefinition = "char")
	private String systemuserId;      
}
