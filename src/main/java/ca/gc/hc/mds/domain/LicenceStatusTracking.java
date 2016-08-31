package ca.gc.hc.mds.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;

import ca.gc.hc.mds.transparent.TranDeviceMaterial;

@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(identifierType=LicenceStatusTrackingPK.class, schema = "MDSDB", table = "LICENCE_STATUS_TRACKING", versionField = "")
public class LicenceStatusTracking {

	   @NotNull
	    @Column(name = "OPERATOR", columnDefinition = "char", length=25 )    
	    private String operator;
	    
	    @NotNull
	    @Column(name = "ACTION_COMPLETED", columnDefinition = "char" , length=1)    
	    private String actionCompleted;
	    
	    
	    @NotNull
	    @Column(name = "ENTRY_DT_TM", columnDefinition = "DATE" )
	    @Temporal(TemporalType.TIMESTAMP)
	    @DateTimeFormat(style = "M-")
	    private Date entryDtTm;
	      
	    @Column(name = "BF_DATE", columnDefinition = "DATE" )
	    @Temporal(TemporalType.TIMESTAMP)
	    @DateTimeFormat(style = "M-")
	    private Date bfDate;
    
    
 
    
    public static LicenceStatusTracking findCurrentLicenceStatusForApplication(Long applicationID){
		
		LicenceStatusTracking results = null;
		
		if ( applicationID == null ){
			throw new IllegalArgumentException("Missing argument: applicationID  is required.");
			
		}
		
		EntityManager entityManager = LicenceStatusTracking.entityManager();
		
				
		/*String queryStr = "SELECT NEW ca.gc.hc.mds.domain.LicenceStatusTracking " 				
		+ "FROM LicenceStatusTracking AS lt "
		+ "WHERE lt.id.applicationId = :applicationID  and lt.id.licenceStatus = 'I' "		
		+ "ORDER BY lt.entryDateTime  ";*/
			
		String queryStr = "SELECT lt FROM LicenceStatusTracking lt WHERE lt.id.applicationId = :applicationID "					
				+ "ORDER BY lt.entryDtTm desc ";
		
		TypedQuery<LicenceStatusTracking> query = entityManager.createQuery(queryStr, LicenceStatusTracking.class);		
		query.setParameter("applicationID", applicationID);		
		
		if (!query.getResultList().isEmpty()){
		results = query.getResultList().get(0);		
		}
		
		return results;		
	}
}
