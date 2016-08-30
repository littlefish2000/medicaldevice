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
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "REASON_CD", 
identifierField = "reasonCd",table = "AMENDMENT_REASON", finders =
{"findAmendmentReasonsByReasonCd"})
public class AmendmentReason {
		@Id
	    @Type(type = "fixedLengthCharType")
	    @Column(name = "REASON_CD", columnDefinition = "char",nullable=false, length=4)
	    @Length(min=1,max = 4,message ="The value must be 1-4 characters")
	    private  String reasonCd;
	    

	    
	    @Column(name = "DESCR", columnDefinition = "char",nullable=false, length=40)
	    @Type(type = "fixedLengthCharType")
	    @Length(min=0,max = 40,message ="The value must be 0-40 characters")
	    private String descr;
	   

}
