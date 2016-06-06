package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "DEVICE_ID", identifierField = "deviceId", table = "DEVICE", finders = { "findDevicesByDeviceId" })
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEVICE_ID")
	private Long deviceId;
	
    /**
     */
    @Column(name = "TRADE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    private String tradeName;
	
		
}
