package ca.gc.hc.mds.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;



@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "SEQ_INTEND_INDIC_ID", 
identifierField = "seqIntendIndicId",table = "LIC_INTENDED_INDICATION_USE", finders =
{"findLicIntendedIndicationUsesBySeqIntendIndicId"})
public class LicIntendedIndicationUse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="indication_seq")
	@SequenceGenerator(
			name="indication_seq",
			sequenceName="SEQ_INTENDED_INDICATION",
			allocationSize=20
		)

	@Column(name = "SEQ_INTEND_INDIC_ID")
	private Long seqIntendIndicId;
		
	@OneToOne(optional=false)
    @JoinColumn(name = "APPLICATION_ID") 
    private Application application;       
	
	@Lob
    @Column(name = "INTENDED_INDICATION_USE", columnDefinition = "CLOB NOT NULL",nullable=false) 
    private String intendedIndicationUse;
	
	@NotNull
    @Column(name = "NOVELL_USER_ID", columnDefinition = "char", length=20 )    
    private String novellUserId;
    
    @NotNull
    @Column(name = "ENTRY_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date entryDt;

}
