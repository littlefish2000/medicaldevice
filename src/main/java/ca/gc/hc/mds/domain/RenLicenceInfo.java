package ca.gc.hc.mds.domain;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = RenLicenceInfoPK.class, table = "REN_LICENCE_INFO",versionField = ""
,finders = { "findRenLicenceInfoesByLicenceNameEquals" },schema = "MDSDB")
public class RenLicenceInfo {
	
    /**
     */
    @Column(name = "LICENCE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    private String licenceName;	
    
    @Column(name = "DATE_ISSUED", nullable = false)
    private Date dateIssued;    
    
    @Column(name = "RECEIPT_DT", nullable = false)
    private Date receiptDt;    
	
    @Column(name = "POSTED_DT", nullable = false)
    private Date postDt;    
	
    @Column(name = "INVOICE_DT", nullable = false)
    private Date invoiceDt;  
    
    
    public static  List<RenLicenceInfo> findRenLicenceInfosByLicenceNo(BigDecimal originalLicenceNo) {
        if (originalLicenceNo == null) throw new IllegalArgumentException("The originalLicenceNo argument is required");
        EntityManager em = CompanyContact.entityManager();
        TypedQuery<RenLicenceInfo> q = em.createQuery("SELECT o FROM RenLicenceInfo AS o WHERE o.id.originalLicenceNo = :licNo", RenLicenceInfo.class);
        q.setParameter("licNo", originalLicenceNo);
        return q.getResultList();
    }  
    
    public static List<RenLicenceInfo> findRenLicenceInfosByLicenceNo(BigDecimal originalLicenceNo,int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM RenLicenceInfo AS o WHERE o.id.originalLicenceNo = :licNo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        EntityManager em = CompanyContact.entityManager();
        TypedQuery<RenLicenceInfo> q = em.createQuery(jpaQuery, RenLicenceInfo.class);
        q.setParameter("licNo", originalLicenceNo);
        return q.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
        
	
}
