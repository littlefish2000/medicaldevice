package ca.gc.hc.mds.domain;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
public final class RenLicenceInfoPK {

    /**
     */
    @Column(name = "RENEWAL_RUN_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date renewalRunDt;

    /**
     */
    @Column(name = "COMPANY_AUTH_ID", nullable = false)
    @DateTimeFormat(style = "M-")
    private BigDecimal companyAuthId;

    /**
     */
    @Column(name = "COMPANY_ID", nullable = false)
    @DateTimeFormat(style = "M-")
    private BigDecimal companyId;
    
    /**
     */
    @Column(name = "ORIGINAL_LICENCE_NO", nullable = false)
    @DateTimeFormat(style = "M-")
    private BigDecimal originalLicenceNo;    
}
