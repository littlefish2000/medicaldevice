package ca.gc.hc.mds.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class SpecialAccessDevicePK {
	
	@Column(name = "SPECIAL_ACCESS_ID", columnDefinition = "NUMBER", nullable = false)
	private Long specialAccessID;
	
	@Column(name = "DEVICE_ID", columnDefinition = "NUMBER", nullable = false)
	private Long deviceID;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "DEVICE_IDENTIFIER", columnDefinition = "char", nullable=false, length=50)
	private String deviceIdentifier;

	public Long getDeviceID() {
		return deviceID;
	}
	
	

}
