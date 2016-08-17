package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", table = "ESTABLISHMENT")
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class Establishment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "ESTABLISHMENT_ID", columnDefinition = "NUMBER")
	private Long establishmentId;	    
	
    @Column(name = "COMPANY_ID", columnDefinition = "NUMBER")
    private Long companyId;	
   
    @Column(name = "EST_CONTACT_ID", columnDefinition = "NUMBER")
    private Long estContactId;	
    
    @Column(name = "COMPANY_MAIL_ID", columnDefinition = "NUMBER")
    private Long companyMailId;	  
    
    @Column(name = "MAIL_CONTACT_ID", columnDefinition = "NUMBER")
    private Long mailContactId;	  
         
    @Column(name = "COMPANY_ADD_ID", columnDefinition = "NUMBER")
    private Long comapnyAddId;	  
             
    @Column(name = "ADD_CONTACT_ID", columnDefinition = "NUMBER")
    private Long addContactId;	  
                 
    /**
     */
    @Column(name = "LICENCE_STATUS", nullable = true, length=1,columnDefinition = "char(1)")
    @Type(type = "fixedLengthCharType")
    private String licenceStatus;
    public String getLicenceStatus() {
        return licenceStatus;
    }      
	    
}
