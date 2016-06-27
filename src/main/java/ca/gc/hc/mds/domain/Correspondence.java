package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB", identifierColumn = "SEQ_CORR_ID", identifierField = "seqcorrId"
,table = "CORRESPONDENCE",finders = { "findCorrespondencesBySeqcorrId","findCorrespondencesByApplicationId",
"findCorrespondencesByOrginallicenceIdEquals", "findCorrespondencesByCompanyIdEquals","findCorrespondencesByCertificateIdEquals"})
public class Correspondence {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ_CORR_ID",columnDefinition = "NUMBER")
    private Long seqcorrId;
    
	@Column(name = "APPLICATION_ID",columnDefinition = "NUMBER")
	private Long applicationId;    
    
	@Column(name = "ORIGINAL_LICENCE_NO",columnDefinition = "NUMBER")
	private Long orginallicenceId;   
    
	@Column(name = "COMPANY_ID",columnDefinition = "NUMBER")
	private Long companyId;   
    
	@Column(name = "CERTIFICATE_ID", columnDefinition = "char")
	private String certificateId;  	
	
	@Column(name = "INCIDENT_ID",columnDefinition = "NUMBER")
	private Long incidentId; 
	
	@Column(name = "CORR_COMPANY_ID",columnDefinition = "NUMBER")
	private Long corrcompanyId; 
	

    /**
     */
    @Column(name = "ADDR_LINE_1", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine1;

    /**
     */
    @Column(name = "ADDR_LINE_2", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine2;

    /**
     */
    @Column(name = "ADDR_LINE_3", columnDefinition = "char")
    @Size(min = 0, max = 45)
    private String addressLine3;	
}
