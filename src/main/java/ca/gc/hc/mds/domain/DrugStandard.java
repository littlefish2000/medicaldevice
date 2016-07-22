package ca.gc.hc.mds.domain;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "DRUG_STANDARD_CD", 
identifierField = "drugstandardCd", identifierType = String.class, table = "DRUG_STANDARD",finders =
{ "findDrugStandardsByDrugstandardDescEquals",
		})
public class DrugStandard {
	
    @Id
    @Column(name = "DRUG_STANDARD_CD", columnDefinition = "char",nullable=false, length=8)
    private String drugstandardCd;
    
    @Column(name = "DRUG_STANDARD_DESC", columnDefinition = "char",nullable=false, length=35)
    private String drugstandardDesc;
    
	public static DrugStandard findDrugStandard(String drugstandardCd) {
        if (drugstandardCd == null || drugstandardCd.length() == 0) throw new IllegalArgumentException("The drugstandardCd argument is required");
        
        EntityManager em = DrugStandard.entityManager();
        TypedQuery<DrugStandard> q = em.createQuery("SELECT o FROM DrugStandard AS o WHERE o.drugstandardCd ='"+ drugstandardCd+ "'", DrugStandard.class);
        if (q.getResultList().size()>0)
        	return q.getResultList().get(0);
        else
        	return null;
    }
        
    
}
