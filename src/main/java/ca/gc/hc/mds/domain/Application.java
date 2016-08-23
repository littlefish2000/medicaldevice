package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.reference.ApplicationType;
import ca.gc.hc.mds.reference.DevLicenceType;
import ca.gc.hc.mds.reference.LicenceStatusType;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
////@RooJpaActiveRecord(sequenceName = "APPLICATION_SEQ", schema = "MDSDB",identifierColumn = "APPLICATION_ID", identifierField = "applicationId", table = "APPLICATION")
@RooJpaActiveRecord(versionField = "", table = "APPLICATION", schema = "MDSDB",identifierColumn = "APPLICATION_ID", identifierField = "applicationId", finders = { "findApplicationsByApplicationId","findApplicationsByOrginLicenseId" })
@SecondaryTables({
    @SecondaryTable(name="LICENCE_STATUS_TRACKING", schema = "MDSDB", pkJoinColumns={
        @PrimaryKeyJoinColumn(name="APPLICATION_ID", referencedColumnName="APPLICATION_ID") }),

})
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICATION_ID")
	private Long applicationId;
	
    /**
     */
    @NotNull
    @Column(name = "ORIGINAL_LICENCE_NO",nullable = false, columnDefinition = "NUMBER")
    private long  orginLicenseId;

    /**
     */
    @NotNull
    @Column(name = "ENTRY_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate;

    /**
     */
    @NotNull
    @Column(name = "RECEIPT_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date receiptDate;

    /**
     */
    @NotNull
    @Column(name = "APPLICATION_DESC")
    @Size(min = 0, max = 350)
    private String applicationDesc;
    
    
   
    @Column(name = "APPLICATION_COMMENTS")
    @Size(min = 0, max = 350)
    private String applicationComments;
    
    /**
     */
    @Column(name = "LICENCE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    private String licenceName;
        
    /**
     */
    @NotNull
	@Column(name = "LICENCE_STATUS_DT",table="LICENCE_STATUS_TRACKING",  columnDefinition = "DATE" )
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date licenceStatusDate;  
    
    /**
     */
    @Column(name = "APPLICATION_TYPE", nullable = true, length=1,columnDefinition = "char(1) default null")
    //@Enumerated(EnumType.STRING)
    private String applicationType = null;   
    
    /**
     */
    @Column(name = "DEV_LICENCE_TYPE", nullable = true, length=1,columnDefinition = "char(1) default null")
    @Enumerated(EnumType.STRING)
    private DevLicenceType devLicenceType = null;    
    
    /**
     */
    @Column(name = "LICENCE_STATUS", table="LICENCE_STATUS_TRACKING",nullable = true, length=1,columnDefinition = "char(1) default 'A'")
    @Enumerated(EnumType.STRING)
    private LicenceStatusType licenceStatus = null; 
    
    @Column(name = "COMPANY_AUTH_ID", columnDefinition="NUMBER")
    private Long companyAuthId;    
    
    
    @Column(name = "APPL_RISK_CLASS", columnDefinition="NUMBER")
    private Long appRiskClass;     
    
    @Column(name = "COMPANY_ID", columnDefinition="NUMBER")
    private Long companyId;     
  
    @Column(name = "DIVISION_CD", columnDefinition = "char")
    @Size(min = 0, max = 3)
    private String divisionCd;  
    
    @Column(name = "DEVICE_DRUG", columnDefinition = "char", length=1)   
    private String deviceDrug; 
    
    @Column(name = "POINT_OF_CARE", columnDefinition = "char", length=1)   
    private String pointOfCare; 
    
    @Column(name = "HOME_USE_CODE", columnDefinition = "char", length=1)   
    private String homeUseCode; 
    
    @Column(name = "DISCLOSURE_FLAG", columnDefinition = "char", length=1)   
    private String disclosureFlag; 
    
    @Column(name = "NEAR_PATIENT", columnDefinition = "char", length=1)   
    private String nearPatient; 
}
