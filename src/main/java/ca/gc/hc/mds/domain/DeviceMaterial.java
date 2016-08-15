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
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;

@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(identifierType = DeviceMaterialPK.class, schema = "MDSDB", table = "DEVICE_MATERIALS", versionField = "", finders =
{"findDeviceMaterialsByDeviceID"})
public class DeviceMaterial {

	
	/**
	 * 
	 */
	@Column(name = "END_DT", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date endDate;
	
	/**
	 * 
	 */
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "STATUS_CODE", columnDefinition = "char", nullable = false, length = 1)
	@Size(min = 0, max = 1)
	private String statusCode;

	
	
	/**
	 * 
	 */
	@NotNull
	@Column(name="COMMENTS", columnDefinition = "VARCHAR2", nullable = false, length = 120)
	@Size(min = 0, max = 120)
	private String comments;




	
	
}

