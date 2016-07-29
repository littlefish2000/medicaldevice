package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "PHYSICIAN_ID", identifierField = "physicianId", table = "PHYSICIAN", finders = { "findPhysiciansByPhysicianId" })
public class Physician {

	@Id   
    @Column(name = "PHYSICIAN_ID")
    private Long physicianId;

    /**
     */
    @Column(name = "PHYSICIAN_FIRST_NAME", columnDefinition = "char")
    @Size(min = 0, max = 25)
    private String physicianFirstName;

    @Column(name = "PHYSICIAN_LAST_NAME", columnDefinition = "char")
    @Size(min = 0, max = 25)
    private String physicianLastName;
    
	@Column(name = "PHYSICIAN_CITY", columnDefinition = "char")
    @Size(min = 6, max = 20)
    private String physicianCity;
    
    @Column(name = "PHYSICIAN_PROVINCE", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String physicianProvince;
    
    @Column(name = "PHYSICIAN_POSTAL", columnDefinition = "char")
    @Size(min = 0, max = 6)
    private String physicianPostal;
    
    @Column(name = "PHYSICIAN_ADDRESS", columnDefinition = "char")
    @Size(min = 0, max = 50)
    private String physicianAddress;
    
    @Column(name = "PHYSICIAN_ADDRESS2", columnDefinition = "char")
    @Size(min = 0, max = 50)
    private String physicianAddress2;

    @Column(name = "PHYSICIAN_FAX", columnDefinition = "NUMBER")    
    private Long physicianFax;
    
    @Column(name = "PHYSICIAN_PHONE", columnDefinition = "NUMBER")    
    private Long physicianPhone;
    
    @Column(name = "PHYSICIAN_EMAIL", columnDefinition = "char")
    @Size(min = 0, max = 40)
    private String physicianEmail;
    
    @Column(name = "PHYSICIAN_CREDENTIAL", columnDefinition = "char")
    @Size(min = 0, max = 30)
    private String physicianCredential;
}
