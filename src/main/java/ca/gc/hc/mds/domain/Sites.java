package ca.gc.hc.mds.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = SitesPK.class, table = "SITES", versionField = "", schema = "MDSDB")
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class Sites {

	@Column(name = "STATUS", columnDefinition = "char(1)")
    @Type(type = "fixedLengthCharType")
	private String status;
    public String getStatus() {
        return status;
    }  	

	/**
	 */
	@Column(name = "INITIAL_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date initDt;

	/**
	 */
	@Column(name = "STATUS_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date statusDt;
}
