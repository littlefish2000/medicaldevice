package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "APPLICATION_STATUS", 
identifierField = "applicationStatus",table = "APPLICATION_STATUS", finders =
{"findApplicationStatussByApplicationStatus"})
public class ApplicationStatus {
	
	@Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "APPLICATION_STATUS", columnDefinition = "char",nullable=false, length=3)
    @Length(min=1,max = 2,message ="The value must be 1-3 characters")
    private  String applicationStatus;
    

    
    @Column(name = "MED_DESC_ENG", columnDefinition = "char",nullable=false, length=40)
    @Type(type = "fixedLengthCharType")
    @Length(min=0,max = 40,message ="The value must be 0-40 characters")
    private String medDescEng;
    
    @Column(name = "MED_DESC_FR", columnDefinition = "char",nullable=false, length=40)
    @Type(type = "fixedLengthCharType")
    @Length(min=0,max = 40,message ="The value must be 0-40 characters")
    private String medDescFr;
}
