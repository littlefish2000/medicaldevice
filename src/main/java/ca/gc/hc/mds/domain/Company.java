package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.validation.constraints.Size;
import ca.gc.hc.mds.reference.StatusType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "COMPANY", schema = "MDSDB", identifierColumn = "COMPANY_ID", identifierField = "companyId", finders = { "findCompanysByCompanyId","findCompanysByCompanyNameLike"})
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

    /**
     */
    @Column(name = "COMPANY_STATUS", nullable = false, length=1,columnDefinition = "char(1) default 'A'")
    @Enumerated(EnumType.STRING)
    private StatusType companyStatus = StatusType.A;

    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;

    /**
     */
    @Column(name = "TAX_NUMBER1", columnDefinition = "char")
    @Size(min = 0, max = 16)
    private String taxNumber1;

    /**
     */
    @Column(name = "TAX_NUMBER4", columnDefinition = "char")
    @Size(min = 0, max = 16)
    private String taxNumber4;
    
    
    /**
     */
    @Column(name = "MDB_BILL_TO", columnDefinition="NUMBER")
    @Size(min = 0, max = 16)
    private Long billToId;    
    
    /**
     */
    @Column(name = "MDB_FIN_CONTACT_ID", columnDefinition="NUMBER")
    @Size(min = 0, max = 16)
    private Long contactId;     
    
    /**
     */
    @Column(name = "INDUSTRY", columnDefinition="char")
    @Size(min = 0, max = 4)
    private String industry;     

    
    /**
     */
    @Column(name = "STD_COMM_METHOD", columnDefinition="char")
    @Size(min = 0, max = 3)
    private String commonMethod;    
    
    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", targetEntity=CompanyContact.class,fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
    private Set<CompanyContact> contacts = new HashSet<CompanyContact>();
    
    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", targetEntity=CompanyHistory.class,fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
    private Set<CompanyHistory> historys = new HashSet<CompanyHistory>();
    
}
