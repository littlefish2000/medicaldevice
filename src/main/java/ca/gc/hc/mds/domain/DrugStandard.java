package ca.gc.hc.mds.domain;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "DRUG_STANDARD_CD", 
identifierField = "drugstandardCd", identifierType = String.class, table = "DRUG_STANDARD")
public class DrugStandard {
	
	@PrePersist
	private void ensureId(){
	    this.setDrugstandardCd(UUID.randomUUID().toString());
	}
	
    @Id
    @Column(name = "DRUG_STANDARD_CD", columnDefinition = "char",nullable=false, length=8)
    private String drugstandardCd;
    
    @Column(name = "DRUG_STANDARD_DESC", columnDefinition = "char",nullable=false, length=35)
    private String drugstandarddESC;
    
}
