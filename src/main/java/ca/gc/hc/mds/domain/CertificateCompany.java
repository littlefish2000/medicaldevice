package ca.gc.hc.mds.domain;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB",identifierType = CertificateCompanyPK.class,
table = "CERTIFICATE_COMPANY",finders = { "findCertificateCompanysByCompanyIdLike" })
public class CertificateCompany {
	
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
    
	@Column(name="NAME_RATIONAL", columnDefinition = "char", nullable=false, length=280)	
	private String nameRational;  
	
	@PersistenceContext
    transient EntityManager entityManager;
	
	
    public static TypedQuery<CertificateCompany> findCertificateCompanysByCompanyAuthIdEquals(BigDecimal companyAuthId) {
        if (companyAuthId == null) throw new IllegalArgumentException("The entryDate argument is required");
        EntityManager em = CertificateCompany.entityManager();
        TypedQuery<CertificateCompany> q = em.createQuery("SELECT o FROM CertificateCompany AS o WHERE o.id.companyAuthId = :companyAuthId", CertificateCompany.class);
        q.setParameter("companyAuthId", companyAuthId);
        return q;
    }
    
}