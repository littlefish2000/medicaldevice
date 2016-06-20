package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

@RooToString
@RooEquals
@RooIdentifier
public final class RenewalPK {

    /**
     */
    @Column(name = "RENEWAL_RUN_DT")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar renewalRunDt;

    /**
     */
    @Column(name = "COMPANY_AUTH_ID")
    @DateTimeFormat(style = "M-")
    private BigDecimal companyAuthId;

    /**
     */
    @Column(name = "COMPANY_ID")
    @DateTimeFormat(style = "M-")
    private BigDecimal companyId;
}
