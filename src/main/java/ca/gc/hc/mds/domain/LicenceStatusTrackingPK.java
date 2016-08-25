
package ca.gc.hc.mds.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;


@RooToString
@RooEquals
@RooIdentifier
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class LicenceStatusTrackingPK {
	
	@Column(name = "APPLICATION_ID",columnDefinition = "NUMBER", nullable = false)
	private Long applicationId;
	
    /**
     */
	@Type(type = "fixedLengthCharType")
    @Column(name = "LICENCE_STATUS",nullable = false, columnDefinition = "char",length = 1)
    private String  licenceStatus;
	
	@NotNull
    @Column(name = "LICENCE_STATUS_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date licenceStatusDt;

}
