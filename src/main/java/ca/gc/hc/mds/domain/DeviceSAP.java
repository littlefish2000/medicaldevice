package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
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
@RooJpaActiveRecord(schema = "MDSDB", table = "DEVICE_SAP", identifierColumn = "DEVICE_ID", identifierField = "deviceID",  versionField = "", finders ={"findDeviceSAPsByDeviceID"})
public class DeviceSAP {
	
	@Id
	@NotNull
	@Column(name = "DEVICE_ID", columnDefinition = "NUMBER", nullable = false)
	private Long deviceID;
		
	
	@Column (name = "INDICATION_USE", columnDefinition="VARCHAR2", length = 2000, nullable=true)
	@Size(min=0, max=2000, message="Max limit for Indication Use is 2000 characters.")
	private String indicationUse;
	

	@Column (name="INITIAL_SAP_DIAG", columnDefinition="VARCHAR2", length = 500, nullable = true)
	@Size(min=0, max=500, message = "Max limit for Initial Sap Diag is 500 characters.")
	private String initialSapDiag;
	

	@Column(name="FUTURE_CONSIDERATION", columnDefinition="VARCHAR2", length=1000, nullable=true)
	@Size(min=0, max=1000, message = "Max limit for Consideration is 1000 characters.")
	private String consideration;
		
	
	@Column(name="SAP_NOTES", columnDefinition = "VARCHAR2", length=2000, nullable=true)
	@Size(min=0, max=2000, message = "Max limit for Sap Note is 2000 characters.")
	private String sapNotes;
	
		
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "STATUS", columnDefinition = "char", length = 1, nullable = false)
	@Size(min = 0, max = 1)
	private String status;

}


