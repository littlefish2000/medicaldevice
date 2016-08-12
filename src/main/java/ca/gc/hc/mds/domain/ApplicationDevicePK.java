package ca.gc.hc.mds.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
public final class ApplicationDevicePK implements Serializable {
	
    @Column(name = "APPLICATION_ID", nullable = false,columnDefinition = "NUMBER")
    private Long applicationId;
    
    @Column(name = "DEVICE_ID", nullable = false,columnDefinition = "NUMBER")
    private Long deviceId;    
}
