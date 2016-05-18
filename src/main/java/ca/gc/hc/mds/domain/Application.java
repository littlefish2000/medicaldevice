package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierColumn = "APPLICATION_ID", identifierField = "id", table = "APPLICATION", finders = { "findApplicationsByApplcationNameLike", "findApplicationsById" })
public class Application {

    /**
     */
    @NotNull
    @Column(name = "APPLICATION_NAME")
    @Size(min = 3, max = 30)
    private String applcationName;

    @NotNull
    @Column(name = "ORIGINAL_LICENCE_NO")
    private long orginLicenseId;

    /**
     */
    @NotNull
    @Column(name = "ENTRY_DT")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDate;

    /**
     */
    @NotNull
    @Column(name = "RECEIPT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date receiptDate;

    /**
     */
    @NotNull
    @Column(name = "LICENCE_NAME")
    @Size(min = 0, max = 150)
    private String licenceName;

    /**
     */
    @NotNull
    @Column(name = "POINT_OF_CARE")
    private boolean pointofCare;

    /**
     */
    @NotNull
    @Column(name = "HOME_USE_CODE")
    private boolean homeuseCode;

    /**
     */
    @NotNull
    @Column(name = "NEAR_PATIENT")
    private boolean nearPatient;

    /**
     */
    @Enumerated
    private ApplicationType applType;
}
