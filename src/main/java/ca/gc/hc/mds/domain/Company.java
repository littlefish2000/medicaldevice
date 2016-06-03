package ca.gc.hc.mds.domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.reference.StatusType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(versionField = "", table = "COMPANY", schema = "MDSDB",identifierColumn = "COMPANY_ID", identifierField = "companyId", finders = { "findCompanysByCompanyNameLike", "findCompanysByCompanyId" })
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
    /**
     */
    @Column(name = "COMPANY_NAME", columnDefinition = "char")
    @Size(min = 0, max = 90)
    private String companyName;

    /**
     */
    @Column(name = "ADDR_LINE_1", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine1;

    /**
     */
    @Column(name = "ADDR_LINE_2", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine2;

    /**
     */
    @Column(name = "ADDR_LINE_3", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine3;
    
    /**
     */
    @Column(name = "ADDR_LINE_4", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine4;
    
    /**
     */
    @Column(name = "ADDR_LINE_5", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine5;
    
        
    /**
     */
    @Column(name = "POSTAL_CODE", columnDefinition = "char")
    @Size(min = 0, max = 12)
    private String postCode;

    /**
     */
    @Column(name = "REGION_CODE", columnDefinition = "char")
    @Size(min = 0, max = 12)
    private String regionCode;
    
    /**
     */
    @Column(name = "CITY", columnDefinition = "char")
    @Size(min = 0, max = 35)
    private String city;

    
    /**
     */
    @Column(name = "COUNTRY_CD", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String country;
    

    /**
     */
    @Column(name = "REGION_CD", columnDefinition = "char")
    @Size(min = 0, max = 3)
    private String region;
    

    @Column(name = "COMPANY_STATUS", nullable = false, columnDefinition = "char(1) default 'A'")
    @Enumerated(EnumType.STRING)
    private StatusType companyStatus =StatusType.A;    
    
    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;
    
}
