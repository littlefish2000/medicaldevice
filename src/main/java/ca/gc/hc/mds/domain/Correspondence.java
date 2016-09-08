package ca.gc.hc.mds.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.reference.InOutType;
import ca.gc.hc.mds.reference.RegMfgType;
import ca.gc.hc.mds.reference.YesAndNoType;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "", schema = "MDSDB", identifierColumn = "SEQ_CORR_ID", identifierField = "seqcorrId"
,table = "CORRESPONDENCE",finders = { "findCorrespondencesBySeqcorrId","findCorrespondencesByApplicationId","findCorrespondencesByIncidentId",
"findCorrespondencesByOrginallicenceIdEquals", "findCorrespondencesByCompanyIdEquals","findCorrespondencesByCertificateIdEquals"})
public class Correspondence {
	
    @Id    
    @Column(name = "SEQ_CORR_ID",columnDefinition = "NUMBER")   
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="corr_seq")
    @SequenceGenerator(
        name="corr_seq",
        sequenceName="SEQ_CORRESPONDENCE_ID",
        allocationSize=1
    )
    private Long seqcorrId;
    
	@Column(name = "APPLICATION_ID",columnDefinition = "NUMBER default 0",nullable=false )
	private Long applicationId;    
    
	@Column(name = "ORIGINAL_LICENCE_NO",columnDefinition = "NUMBER default 0",nullable=false)
	private Long orginallicenceId;   
    
	@Column(name = "COMPANY_ID",columnDefinition = "NUMBER default 0",nullable=false)
	private Long companyId;   
    
	
	@Column(name = "CERTIFICATE_ID", columnDefinition = "char default ' ' ",nullable=false)
	@Size(min = 0, max = 30)
	@Type(type = "fixedLengthCharType")
	private String certificateId;  	
	
	@Column(name = "INCIDENT_ID",columnDefinition = "NUMBER default 0",nullable=false)
	private Long incidentId; 
	
	
    /**
     */
	
	
	@Column(name = "INBOUND_OUTBOUND", nullable = false, length=1,columnDefinition = "char(1) default 'Z'")
    @Enumerated(EnumType.STRING)
    private InOutType inboundOutbound;

    /**
     */
	
    @Column(name = "APPLICABLE_AREA", columnDefinition = "char",nullable=false)
    @Size(min = 0, max = 1)
    @Type(type = "fixedLengthCharType")
    private String applicableArea;

    @Column(name = "REGULATORY_SECTION", columnDefinition = "NUMBER default 0",nullable=false) 
    private String regulatorySection;	
    
    @Column(name = "LETTER_DATE", columnDefinition = "DATE",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date letterDate;

    
    
    @Column(name = "REG_OR_MFG", nullable = false, length=1,columnDefinition = "char(1) default 'Z'")
    @Enumerated(EnumType.STRING)
    private RegMfgType regOrMfg;
    

   
    @Column(name = "BF_DATE", columnDefinition = "DATE")  
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date bfDate;

    /**
     */
    @Column(name = "RESPONSE_RECEIVED", nullable = false, length=1,columnDefinition = "char(1) default 'N'")
    @Enumerated(EnumType.STRING)
    private YesAndNoType responseReceived;	
    
         
    @Column(name = "CORR_COMPANY_ID",columnDefinition = "NUMBER default 0", nullable=false)
	private Long corrcompanyId; 	
    
    @Column(name = "COMPANY_NAME", columnDefinition = "char default ' '",nullable=false)
    @Size(min = 0, max = 90)
    @Type(type = "fixedLengthCharType")
    private String companyName;
    
    @Column(name = "LICENCE_NAME", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 150)
    @Type(type = "fixedLengthCharType")    
    private String corrLicenceName;
    
    /**
     */
    @Column(name = "ADDR_LINE_1", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 45)
    @Type(type = "fixedLengthCharType")
    private String addressLine1;

    /**
     */
    @Column(name = "ADDR_LINE_2", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 45)
    @Type(type = "fixedLengthCharType")
    private String addressLine2;

    /**
     */
    @Column(name = "ADDR_LINE_3", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 45)
    @Type(type = "fixedLengthCharType")
    private String addressLine3;	
    
    @Column(name = "POSTAL_CODE", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 12)
    @Type(type = "fixedLengthCharType")
    private String postalCode;

    /**
     */
    @Column(name = "CITY", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 35)
    @Type(type = "fixedLengthCharType")
    private String city;

    /**
     */
    @Column(name = "COUNTRY_CD", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 2)
    @Type(type = "fixedLengthCharType")
    private String countryCd;
    
    @Column(name = "REGION_CD", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 3)
    @Type(type = "fixedLengthCharType")
    private String regionCd;
    
    @Column(name = "REMARKS", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 200)    
    private String remarks;
    
    @Type(type = "fixedLengthCharType")
    @Column(name = "DIVISION_CD", columnDefinition = "char default ' '", nullable=false)
    @Size(min = 0, max = 3)  
    private String divisionCd;

    
    @Transient
    private String companyDetails;
    
    /**
     */
    
    
}
