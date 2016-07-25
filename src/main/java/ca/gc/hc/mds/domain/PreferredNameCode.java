package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "PREF_NAME_MAST", 
identifierField = "prefNameCode", identifierType = String.class, table = "PREF_NAME_MAST",finders =
{ "findPreferredNameCodesByPrefNameCode",
		})
public class PreferredNameCode {
	@Id   
    @Column(name = "PREF_NAME_CODE",columnDefinition = "char",nullable=false, length=6)
    private  String prefNameCode;

    /**
     */
    @Column(name = "PREF_DESC_ENG1", columnDefinition = "char",nullable=false, length=60)  
    private String prefDescEng1;

    @Column(name = "PREF_DESC_ENG2", columnDefinition = "char",nullable=false, length=60) 
    private String prefDescEng2;
    
    @Column(name = "PREF_DESC_FR1", columnDefinition = "char",nullable=false, length=60)
    private String prefDescFr1;
    
    @Column(name = "PREF_DESC_FR2", columnDefinition = "char")
    @Size(min = 0, max = 60)
    private String prefDescFr2;    

    @Column(name = "RISK_CLASSIFICATION", columnDefinition = "NUMBER")
    private Integer riskClassification;
    

    @Column(name = "REGULATED_BY", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String regulatedBy;
}
