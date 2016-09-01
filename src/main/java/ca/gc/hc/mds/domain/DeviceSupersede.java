package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
@RooJpaActiveRecord(schema = "MDSDB", table = "DEVICE_SUPERSEDE", identifierColumn = "SUPERSEDED_ID",
		identifierField = "superSededID", versionField = "", finders ={"findDeviceSupersedeBySuperSededID", "findDeviceSupersedeBySuperSedesID"})
public class DeviceSupersede {
	
	@Id
	@NotNull
	@Column(name = "SUPERSEDED_ID", columnDefinition = "NUMBER", nullable = false)
	private Long superSededID;
	
	
	@NotNull
	@Column(name = "SUPERSEDES_ID", columnDefinition = "NUMBER", nullable = false)
	private Long superSedesID;		

}

