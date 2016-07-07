package ca.gc.hc.mds.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
public final class CertificateCompanyPK implements Serializable{
	
    @Column(name = "CERTIFICATE_ID", nullable = false,columnDefinition = "char")
    private String certificateId;
    
    @Column(name = "COMPANY_ID", nullable = false)
    private BigDecimal companyAuthId;
    	
}
