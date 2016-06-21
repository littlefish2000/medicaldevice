package ca.gc.hc.mds.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.TypedQuery;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = RenAuthCompanyPK.class, versionField = "", table = "REN_AUTH_COMPANY", 
finders = { "findRenAuthCompanysByCompanyAuthNameEquals" },schema = "MDSDB")
public class RenAuthCompany {

	
	@Column(name="COMPANY_AUTH_NAME", columnDefinition = "char", nullable=false, length=90)	
	private String companyAuthName;
	
	@Column(name="AUTH_ADDR_1", columnDefinition = "char",nullable=true, length=45)	
	private String authAddr1;
	
	@Column(name="AUTH_ADDR_2",columnDefinition = "char", nullable=true, length=45)	
	private String authAddr2;
	
	@Column(name="AUTH_ADDR_3",columnDefinition = "char", nullable=true, length=45)	
	private String authAddr3;
	
	@Column(name="CITY",columnDefinition = "char", nullable=true, length=35)	
	private String city;
	
	@Column(name="COUNTRY_CD",columnDefinition = "char", nullable=true, length=2)	
	private String countryCd;
	
	@Column(name="REGION_CD",columnDefinition = "char", nullable=true, length=3)	
	private String regionCd;
	
	@Column(name="AUTH_POSTAL_CODE",columnDefinition = "char", nullable=true, length=12)	
	private String authPostalCode;
	
	@Column(name="ENTRY_DT",columnDefinition = "DATE", nullable=true)	
	private java.sql.Timestamp entryDate;
	
	@Column(name="RECEIPT_DT",columnDefinition = "DATE", nullable=true)	
	private java.sql.Timestamp receiptDate;
	
	@Column(name="REJECT_DT",columnDefinition = "DATE", nullable=true)	
	private java.sql.Timestamp rejectDate;
	
	@Column(name="OPERATOR_ID",columnDefinition = "char", nullable=false, length=8)	
	private String operatorId;
	
	@Column(name="COMPLETE_PACKAGE",columnDefinition = "char", nullable=false, length=1)	
	private char compeletePackage;	
	
	public static TypedQuery<RenAuthCompany> findRenAuthCompanyByCompanyAuthorId(Long companyAuthId) {
        if (companyAuthId == null) throw new IllegalArgumentException("The deviceId argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery<RenAuthCompany> q = em.createQuery("SELECT o FROM RenAuthCompany AS o WHERE o.RenAuthCompanyPK.companyAuthId = :companyAuthId", RenAuthCompany.class);
        q.setParameter("companyAuthId", companyAuthId);
        return q;
    }	
	
}
