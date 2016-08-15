package ca.gc.hc.mds.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;


@RooToString
@RooEquals
@RooIdentifier
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class DeviceMaterialPK {
	
	@NotNull
	@Column(name = "DEVICE_ID", columnDefinition = "NUMBER", nullable = false)
	private Long deviceID;
	
	//REFERENCES "MDSDB"."COUNTRY_TAB" ("COUNTRY_CD") 
	@Type(type = "fixedLengthCharType")
	@Column(name = "COUNTRY_CD", columnDefinition = "char", nullable = false, length = 2)
	@Size(min = 0, max = 2)
	private String countryCode;


	// REFERENCES "DEVICE_SPECIES" ("SPECIES_CODE") ,
	@NotNull
	@Column(name = "SPECIES_CODE", columnDefinition = "NUMBER", nullable = false)
	private Long speciesCode;
 


	// REFERENCES "DEVICE_TISSUES" ("TISSUES_CODE")
	@NotNull
	@Column(name = "TISSUES_CODE", columnDefinition = "NUMBER", nullable = false)
	private Long tissuesCode;


	//REFERENCES "DEVICE_DERIVATIVES" ("DERIVATIVES_CODE") 
	@NotNull
	@Column(name = "DERIVATIVES_CODE", columnDefinition = "NUMBER", nullable = false)
	private Long derivativesCode;


	
	@NotNull
	@Column(name = "START_DT", columnDefinition = "DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date startDate;

}





