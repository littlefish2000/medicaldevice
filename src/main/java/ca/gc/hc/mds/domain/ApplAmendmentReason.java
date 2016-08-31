package ca.gc.hc.mds.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "APPLICATION_ID", 
identifierField = "applicationId",table = "APPL_AMENDMENT_REASON", finders =
{"findApplAmendmentReasonsByApplicationId"})
public class ApplAmendmentReason {
	@Id	
	@Column(name = "APPLICATION_ID", columnDefinition = "NUMBER",nullable=false)	
    private Long applicationId;     
	
	@Column(name = "REASON_CD", columnDefinition = "char",nullable=false, length=4) 
    @Type(type = "fixedLengthCharType")
    private String reasonCd;
    
}
