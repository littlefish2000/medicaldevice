package ca.gc.hc.mds.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "DEVICE_ID", identifierField = "deviceId", table = "DEVICE", finders = { "findDevicesByDeviceId","findDevicesByPerfnameCode" })
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
    
    @Column(name = "PREF_NAME_CODE", columnDefinition = "char")
    @Size(min = 6, max = 6)
    private String perfnameCode;
    
    
    /**
     */
    @NotNull
    @Column(name = "ENTRY_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate;
    
    /**
     */
    @NotNull
    @Column(name = "LAST_CHANGE_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date lastChangeDate;
    
	
		
}
