package ca.gc.hc.mds.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@TableGenerator(name="device_generator", table="CONTROL_FILE", valueColumnName = "device_id")
@RooJpaActiveRecord(versionField = "", schema = "MDSDB", identifierColumn = "DEVICE_ID", identifierField = "deviceId", table = "DEVICE", finders = { "findDevicesByDeviceId", "findDevicesByPerfnameCode", "findDevicesByPerfnameCodeLike" })
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="device_generator")
    @Column(name = "DEVICE_ID", columnDefinition = "NUMBER", nullable = false)
    private Long deviceId;

    /**
     */
    @Column(name = "TRADE_NAME", columnDefinition = "char")
    @Size(min = 0, max = 150)
    @Type(type = "fixedLengthCharType")
    private String tradeName;

    @Column(name = "PREF_NAME_CODE", columnDefinition = "char")
    @Size(min = 1, max = 6)
    @Type(type = "fixedLengthCharType")
    private String perfnameCode;

    /**
     */  
    @Column(name = "ENTRY_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate;

    /**
     */
    @Column(name = "LAST_CHANGE_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date lastChangeDate;
    
    
	@Column(name = "RISK_CLASSIFICATION", columnDefinition = "NUMBER", nullable = false)
	private Long riskClassification;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "USAGE_CODE", columnDefinition = "char", nullable = false, length = 2)
	@Size(min = 0, max = 2)
	private String usageCode;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "OBSOLETE_FLAG", columnDefinition = "char", nullable = false, length = 1)
	@Size(min = 0, max = 1)
	private String obsoleteFlag;
    
	@Type(type = "fixedLengthCharType")
	@Column(name = "NEW_REGS_98", columnDefinition = "char", nullable = false, length = 1)
	@Size(min = 0, max = 1)
	private String newRegs98; 
    
}
