package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
////@RooJpaActiveRecord(sequenceName = "APPLICATION_SEQ", schema = "MDSDB",identifierColumn = "APPLICATION_ID", identifierField = "applicationId", table = "APPLICATION")
@RooJpaActiveRecord(versionField = "", table = "APPLICATION", schema = "MDSDB",identifierColumn = "APPLICATION_ID", identifierField = "applicationId", finders = { "findApplicationsByApplicationId" })
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICATION_ID")
	private Long applicationId;
	
    /**
     */
    @NotNull
    @Column(name = "ORIGINAL_LICENCE_NO",nullable = false, columnDefinition = "NUMBER")
    private long  orginLicenseId;

    /**
     */
    @NotNull
    @Column(name = "ENTRY_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate;

    /**
     */
    @NotNull
    @Column(name = "RECEIPT_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date receiptDate;

    /**
     */
    @NotNull
    @Column(name = "APPLICATION_DESC")
    @Size(min = 0, max = 150)
    private String applicationDesc;
}
