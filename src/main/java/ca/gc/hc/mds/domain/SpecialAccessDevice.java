package ca.gc.hc.mds.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = SpecialAccessDevicePK.class, schema = "MDSDB", table = "SPECIAL_ACCESS_DEVICE", versionField = "", finders =
							{"findSpecialAccessDeviceByDeviceID"})
public class SpecialAccessDevice {
	@Column(name = "QUANTITY", columnDefinition = "NUMBER", nullable = false)
	private Long quantity;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "ALT_DEVICE_NAME", columnDefinition = "char", nullable=false, length=45)
	private String altDeviceName;	

}
