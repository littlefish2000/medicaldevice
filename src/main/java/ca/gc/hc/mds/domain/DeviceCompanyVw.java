package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",table = "DEVICE_COMPANY_VW")
public class DeviceCompanyVw {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEVICE_ID",columnDefinition = "NUMBER")
	private Long deviceId;

	/**
	 */
	@Column(name = "APPL_DEVICE_STATUS", columnDefinition = "char", nullable = true, length = 2)
	@Size(min = 0, max = 2)
	private String appldeviceStatus;
	
	@Column(name = "ORIGINAL_LICENCE_NO", columnDefinition = "NUMBER")
	private Long originalLicenceNo;	
	
	@Column(name = "MFG_COMPANY_ID", columnDefinition = "NUMBER")
	private Long mfgCompanyId;	
	
	@Column(name = "AUTH_COMPANY_ID", columnDefinition = "NUMBER")
	private Long authCompanyId;		
}
