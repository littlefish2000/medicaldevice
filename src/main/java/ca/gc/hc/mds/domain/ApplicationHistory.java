package ca.gc.hc.mds.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "APPLICATION_HIST_ID", 
identifierField = "applicationHistId",table = "APPLICATION_HIST", finders =
{"findApplicationHistorysByApplicationHistId"})
public class ApplicationHistory {
	
	@Id
	@NotNull
    @Column(name = "APPLICATION_HIST_ID", columnDefinition = "NUMBER" )    
    private Long applicationHistId;
    
    @NotNull
    @Column(name = "APPLICATION_ID", columnDefinition = "NUMBER")    
    private Long applicationId;
    
    
    @NotNull
    @Column(name = "APPLICATION_STATUS", columnDefinition = "char" ,length=2)
    private String applicationStatus;
      
    @Column(name = "START_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date startDt;

    @NotNull
    @Column(name = "END_DT", columnDefinition = "DATE" )
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date endDt;
      
    @NotNull
    @Column(name = "EVALUATOR", columnDefinition = "char" , length=8)    
    private String evaluator;
    
    @NotNull
    @Column(name = "OPERATOR", columnDefinition = "char" , length=8)    
    private String operator;
    
    @NotNull
    @Column(name = "HISTORY_COMMENTS", columnDefinition = "char" , length=140)    
    private String historyComments;
    
public static ApplicationHistory findCurrentApplicationStatusForApplication(Long applicationID){
		
		ApplicationHistory results = null;
		
		if ( applicationID == null ){
			throw new IllegalArgumentException("Missing argument: applicationID  is required.");
			
		}
		
		EntityManager entityManager = LicenceStatusTracking.entityManager();
		
				
		/*String queryStr = "SELECT NEW ca.gc.hc.mds.domain.LicenceStatusTracking " 				
		+ "FROM LicenceStatusTracking AS lt "
		+ "WHERE lt.id.applicationId = :applicationID  and lt.id.licenceStatus = 'I' "		
		+ "ORDER BY lt.entryDateTime  ";*/
			
		String queryStr = "SELECT ah FROM ApplicationHistory ah WHERE ah.applicationId = :applicationID "					
				+ "ORDER BY ah.applicationHistId desc ";
		
		TypedQuery<ApplicationHistory> query = entityManager.createQuery(queryStr, ApplicationHistory.class);		
		query.setParameter("applicationID", applicationID);		
		
		if(!query.getResultList().isEmpty()){
			results = query.getResultList().get(0);	
		}
		return results;		
	}
}
