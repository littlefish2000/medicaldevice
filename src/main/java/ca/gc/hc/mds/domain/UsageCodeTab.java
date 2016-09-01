package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;


import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * 
 * @author Anisur
 *
 */

@RooJavaBean
@RooToString
@RooEquals
@TypeDef(name = "fixedLengthCharType", typeClass =ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(schema = "MDSDB", table = "USAGE_CODE_TAB", 
	identifierColumn = "USAGE_CODE", identifierField = "usageCode",  versionField = "", 
	finders ={"findUsageCodeTabByUsageCode"})

public class UsageCodeTab {
	 
	 @Id
	 @Column(name = "USAGE_CODE", columnDefinition = "char", nullable=false)
	 @Size(min = 0, max = 2)
	 @Type(type = "fixedLengthCharType")
	 private String usageCode;
	 
	 @Column(name = "DESC_ENG", columnDefinition = "char", nullable=false)
	 @Size(min = 0, max = 60)
	 @Type(type = "fixedLengthCharType")
	 private String descENG;
	 
	 @Column(name = "DESC_FR", columnDefinition = "char", nullable=false)
	 @Size(min = 0, max = 60)
	 @Type(type = "fixedLengthCharType")
	 private String descFR;


}

