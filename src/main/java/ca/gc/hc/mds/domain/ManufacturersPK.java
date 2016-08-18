package ca.gc.hc.mds.domain;

import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
public class ManufacturersPK {

    /**
     */
    @Column(name = "ESTABLISHMENT_ID", nullable = false)
    @DateTimeFormat(style = "M-")
    private Long establishmentId;
    
    /**
     */
    @Column(name = "MFG_ID", nullable = false)
    @DateTimeFormat(style = "M-")
    private Long mfgId;    
}
