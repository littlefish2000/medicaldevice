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
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "SPECIAL_ACCESS_ID", identifierField = "specialId", table = "SPECIAL_ACCESS", finders = { "findSpecialAccessesBySpecialId" })
public class SpecialAccess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPECIAL_ACCESS_ID")
	private Long specialId;


	@Column(name = "PHYSICIAN_ID", columnDefinition="NUMBER")
	private Long physicianId;
			
	@Column(name = "FACILITY_ID", columnDefinition="NUMBER")
	private Long facilityId;
	
    /**
     */
    @NotNull
    @Column(name = "REQUESTED_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date requestDate;	

    /**
     */
    @NotNull
    @Column(name = "ACTION_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date actionDate;	

    /**
     */
    @NotNull
    @Column(name = "AI_RECEIPT_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date aiReceiptDate;	    
    
    
    /**
     */
    @Column(name = "REFERENCE", columnDefinition = "char")
    @Size(min = 0, max = 60)
    private String reference;    
	    
			
}
