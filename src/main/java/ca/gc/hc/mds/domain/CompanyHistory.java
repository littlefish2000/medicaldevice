package ca.gc.hc.mds.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
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
@RooJpaActiveRecord(versionField = "", table = "COMPANY_HISTORY", schema = "MDSDB", identifierColumn = "COMPANY_HISTORY_ID", identifierField = "companyHistoryId", finders = {
		"findCompanyHistorysByCompany" })
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class CompanyHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_HISTORY_ID")
	private Long companyHistoryId;

	/**
	 */
	@NotNull
	@Column(name = "CHANGE_DT", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date changeDate;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "COMPANY_NAME", columnDefinition = "char", nullable = false, length = 90)
	private String companyName;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "ADDR_LINE_1", columnDefinition = "char", nullable = false, length = 45)
	private String addressLine1;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "ADDR_LINE_2", columnDefinition = "char", nullable = false, length = 45)
	private String addressLine2;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "ADDR_LINE_3", columnDefinition = "char", nullable = false, length = 45)
	private String addressLine3;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "ADDR_LINE_4", columnDefinition = "char", nullable = false, length = 45)
	private String addressLine4;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "ADDR_LINE_5", columnDefinition = "char", nullable = false, length = 45)
	private String addressLine5;

	/**
	 */
    @Type(type = "fixedLengthCharType")
	@Column(name = "POSTAL_CODE", columnDefinition = "char", nullable = false, length = 12)
	private String postCode;
	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "REGION_CODE", columnDefinition = "char", nullable = false, length = 2)
	private String regionCode;
	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "CITY", columnDefinition = "char", nullable = false, length = 35)
	private String city;
	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "COUNTRY_CD", columnDefinition = "char", nullable = false, length = 2)
	private String country;
	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "REGION_CD", columnDefinition = "char", nullable = false, length = 3)
	private String region;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "COMPANY_STATUS", columnDefinition = "char", nullable = false, length = 1)
	private String companyStatus;

	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "FEE_REDUCTION", columnDefinition = "char", nullable = false, length = 1)
	private String feeReduction;
	/**
	 */
	@NotNull
    @Column(name = "GROSS_REVENUE", columnDefinition = "NUMBER(10,2)", nullable = false)
    private Double grossRevenue;


	/**
	 */
	@NotNull
    @Column(name = "MDB_BILL_TO", columnDefinition = "NUMBER", nullable = false)
    private Long mdbBillTo;


	@ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns({ @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", nullable = false) })
	private Company company;
}
