package ca.gc.hc.mds.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.reference.LicenceStatusType;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB",table = "RPT_LICENCE")
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class RptLicence {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "ORIGINAL_LICENCE_NO", columnDefinition = "NUMBER")
	private Long originalLicenceNo;	
	
    /**
     */
    @Column(name = "LICENCE_STATUS", nullable = true, length=1,columnDefinition = "char(1)")
    @Type(type = "fixedLengthCharType")
    private String licenceStatus;
    public String getLicenceStatus() {
        return licenceStatus;
    }      
	
    /**
     */
    @Column(name = "APPLICATION_TYPE", nullable = true, length=1,columnDefinition = "char(1)")
    @Type(type = "fixedLengthCharType")
    private String applicationType;
    public String getApplicationType() {
        return licenceStatus;
    }      
    
	@Column(name = "APPLICATION_ID", columnDefinition = "NUMBER")
	private Long applicationId;	    
	
    @Column(name = "COMPANY_ID", columnDefinition = "NUMBER")
    private Long companyId;	
    
    @Column(name = "COMPANY_AUTH_ID", columnDefinition="NUMBER")
    private Long companyAuthId;  
    
    @Column(name = "DATE_ISSUED", nullable = false)
    private Date dateIssued;  
    
	@Column(name = "APPL_RISK_CLASS", columnDefinition = "NUMBER")
	private Long applRiskClass;	
	
    @Column(name = "LICENCE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    private String licenceName;
    
    @Column(name = "REG_CONTACT_ID")
    private Long regContactId;    
	    
}


