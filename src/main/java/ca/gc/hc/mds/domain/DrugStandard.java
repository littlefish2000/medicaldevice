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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.CharacterType;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "DRUG_STANDARD_CD", 
identifierField = "drugstandardCd",  table = "DRUG_STANDARD",finders =
{ "findDrugStandardsByDrugstandardDescEquals",
		})
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class DrugStandard {
	
    @Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "DRUG_STANDARD_CD", columnDefinition = "char",nullable=false, length=8)
    private  String drugstandardCd;
    
    public String getDrugstandardCd() {
        return drugstandardCd;
    }    
    
    @Column(name = "DRUG_STANDARD_DESC", columnDefinition = "char",nullable=false, length=35)
    @Type(type = "fixedLengthCharType")
    private String drugstandardDesc;
    public String getDrugstandardDesc() {
        return drugstandardDesc;
    }    
    
    
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
