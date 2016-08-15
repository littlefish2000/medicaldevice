package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "", table = "DEVICE_DERIVATIVES", schema = "MDSDB",identifierColumn = "DERIVATIVES_CODE", identifierField = "derivativesCode", finders = { "findDeviceDerivativesByDerivativesCode" })
public class DeviceDerivatives {
	
	@NotNull
	@Id
	@Column(name = "DERIVATIVES_CODE", columnDefinition = "NUMBER", nullable = false)
	private Long derivativesCode;
	
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "DESC_ENG", columnDefinition = "char", nullable = false, length = 25)
	@Size(min = 0, max = 25)
	private String descEng;
	
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "DESC_FR", columnDefinition = "char", nullable = false, length = 25)
	@Size(min = 0, max = 25)
	private String descFR;

}

/** 
  CREATE TABLE "MDSDB"."DEVICE_DERIVATIVES" 
   (	"" NUMBER NOT NULL ENABLE, 
	"DESC_ENG" CHAR(25 BYTE) NOT NULL ENABLE, 
	"DESC_FR" CHAR(25 BYTE) NOT NULL ENABLE, 
	 
 
   ) 
 */
