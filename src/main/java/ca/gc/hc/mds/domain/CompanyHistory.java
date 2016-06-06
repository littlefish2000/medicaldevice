package ca.gc.hc.mds.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Size;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "COMPANY_HISTORY", schema = "MDSDB",identifierColumn = "COMPANY_HISTORY_ID", identifierField = "companyHistoryId",  finders = { "findCompanyHistorysByCompany" })

public class CompanyHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_HISTORY_ID")
	private Long companyHistoryId;
	
    /**
     */
    @NotNull
    @Column(name = "CHANGE_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date changeDate;
    
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
    
	
		
	
    @ManyToOne(targetEntity=Company.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="COMPANY_ID", referencedColumnName="COMPANY_ID", nullable=false) })	
	private Company company;
}
