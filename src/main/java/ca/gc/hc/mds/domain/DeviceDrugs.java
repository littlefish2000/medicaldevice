package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;

/**
 * 
 * @author Anisur
 *
 */

@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(identifierType = DeviceDrugsPK.class, schema = "MDSDB", table = "DEVICE_DRUGS",
					versionField = "", finders = {"findDeviceDrugsesByDeviceID"})
public class DeviceDrugs {
	
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "DRUG_STANDARD_CD", columnDefinition = "char", nullable = false, length = 8)
	@Size(min = 0, max = 8)
	private String drugStandardCD;

}
