package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.validation.constraints.Size;

import ca.gc.hc.mds.reference.StatusType;
import ca.gc.hc.mds.reference.YesAndNoType;

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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.TableGenerator;
import org.apache.commons.lang.StringUtils;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "COMPANY", schema = "MDSDB", identifierColumn = "COMPANY_ID", identifierField = "companyId", finders = { "findCompanysByCompanyId","findCompanysByCompanyNameLike"})
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@DynamicUpdate(value=true)
public class Company {

    @Id
    @TableGenerator( name = "company_generator", table = "CONTROL_FILE",// pkColumnName = "ESTABLISHMENT_ID",
    pkColumnValue = "COMPANY_PK", valueColumnName = "COMPANY_ID", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "company_generator" )
    @Column(name = "COMPANY_ID")
    private Long companyId;
    /**
     */
    @NotNull
    @Type(type = "fixedLengthCharType")
    @Column(name = "COMPANY_NAME", columnDefinition = "char")
    @Size(min = 0, max = 90)
    private String companyName;
	public String getCompanyName() {
		return companyName;
	}    

    /**
     */
    @Type(type = "fixedLengthCharType")
    @Column(name = "ADDR_LINE_1", columnDefinition = "char", nullable = true,length = 45)
    @Size(min = 0, max = 45)
    private String addressLine1;
	public String getAddressLine1() {
		return addressLine1;
	}
	
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "ADDR_LINE_2", columnDefinition = "char",nullable = true, length = 45)
    @Size(min = 0, max = 45)
    private String addressLine2;
	public String getAddressLine2() {
		return addressLine2;
	}
	
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "ADDR_LINE_3", columnDefinition = "char",nullable = true, length = 45)
    @Size(min = 0, max = 45)
    private String addressLine3;
	public String getAddressLine3() {
		return addressLine3;
	}
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "ADDR_LINE_4", columnDefinition = "char",nullable = true, length = 45)
    @Size(min = 0, max = 45)
    private String addressLine4;
	public String getAddressLine4() {
		return addressLine4;
	}
	
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "ADDR_LINE_5", columnDefinition = "char",nullable = true, length = 45)
    @Size(min = 0, max = 45)
    private String addressLine5;
	public String getAddressLine5() {
		return addressLine5;
	}    

    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "POSTAL_CODE", nullable = true, columnDefinition = "char",length = 12)
    @Size(max = 12)
    private String postCode;;
	public String getPostCode() {
		return postCode;
	}    
	
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "REGION_CODE",nullable = true, columnDefinition = "char")
    @Size(max = 12)
    private String regionCode;

    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "CITY",nullable = true, columnDefinition = "char")
    @Size(max = 35)
    private String city;

    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "COUNTRY_CD", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String country;

    /**
     */
	@Type(type = "fixedLengthCharType")
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
    @Column(name = "TAX_NUMBER1", nullable = true,columnDefinition = "char",length = 16)
    @Size(max = 16)
    private String taxNumber1;

    /**
     */
    @Column(name = "TAX_NUMBER4",nullable = true, columnDefinition = "char",length = 16)
    @Size(max = 16)
    private String taxNumber4;
    
    
    /**
     */
    @Column(name = "MDB_BILL_TO", columnDefinition="NUMBER")
    private Long billToId;    
    
    /**
     */
    @Column(name = "MDB_FIN_CONTACT_ID", columnDefinition="NUMBER")
    private Long contactId;     
    
    /**
     */
    @Column(name = "INDUSTRY",nullable = true, columnDefinition="char")
    @Size(max = 4)
    private String industry;     

    
    /**
     */
    @Column(name = "STD_COMM_METHOD", nullable = true,columnDefinition="char",length = 3)
    @Size(max = 3)
    private String commonMethod;    
    
    
    /**
     */
    @Column(name = "FEE_REDUCTION_DT", nullable = true,columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date lastChangeDate;
    
    /**
     */
    @Type(type = "fixedLengthCharType")
    @Column(name = "NEW_REGS_98", nullable = false, length=1,columnDefinition = "char(1) default 'Y'")
    private String newreg89 = "Y";   
    
    
    /**
     */
    @Type(type = "fixedLengthCharType")
    @Column(name = "FEE_REDUCTION", nullable = false, length=1,columnDefinition = "char(1) default 'N'")
    private String feeReduction = "N";    
    
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
    

    
    @PrePersist
    void preInsert() {
//    	if (feeReduction==null) {
//    		System.out.println("feeReduction is null");
//    		feeReduction ="";
//    	}
    	preUpdateValuesWithWhiteSpace();
//    	StringUtils.trim(newreg89);
//    	StringUtils.trim(feeReduction);
    	
    }

    @PreUpdate
    void preUpdate() {
//    	if (feeReduction==null) {
//    		System.out.println("feeReduction is null");
//    		feeReduction ="";
//    	}
//    	
        preUpdateValuesWithWhiteSpace();
//    	StringUtils.trim(newreg89);
//    	StringUtils.trim(feeReduction);        
    }   

    protected void preUpdateValuesWithWhiteSpace() {
//    	StringUtils.rightPad(newreg89,1);
//    	StringUtils.rightPad(feeReduction,1);
    	StringUtils.rightPad(companyName,90);
    	StringUtils.rightPad(addressLine1, 45);
    	StringUtils.rightPad(addressLine2, 45);
    	StringUtils.rightPad(addressLine3, 45);
    	StringUtils.rightPad(addressLine4, 45);
    	StringUtils.rightPad(addressLine5, 45);
    	StringUtils.rightPad(postCode, 12);
    	StringUtils.rightPad(regionCode, 2);
    	StringUtils.rightPad(city, 35);
    	StringUtils.rightPad(country, 2);
    	StringUtils.rightPad(region, 3);
    }      
    
    
}
