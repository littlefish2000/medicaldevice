package ca.gc.hc.mds.domain;
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
@RooJpaActiveRecord(versionField = "", table = "COMPANY_CONTACT", schema = "MDSDB",identifierColumn = "COMPANY_CONTACT_ID", identifierField = "companyContactId",  finders = { "findCompanyContactsByCompany" })
public class CompanyContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_CONTACT_ID")
	private Long companyContactId;
	
    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;
	
	@Column(name="CONTACT_NAME", nullable=false, length=45, columnDefinition = "char")	
	private String contactName;
	
	@Column(name="CONTACT_TITLE", nullable=false, length=45, columnDefinition = "char")	
	private String contactTitle;
	
	
	@Column(name="E_MAIL", nullable=false, length=70, columnDefinition = "char")	
	private String e_MAIL;
	

    @ManyToOne(targetEntity=Company.class, fetch=FetchType.EAGER)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="COMPANY_ID", referencedColumnName="COMPANY_ID", nullable=false) })	
	//@org.hibernate.annotations.Index(name="COMP_CON_IDX")	
	private Company company;
    
}
