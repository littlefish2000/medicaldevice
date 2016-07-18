package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "FACILITY_ID", identifierField = "facilityId", table = "FACILITY", finders = { "findFacilitysByFacilityId" })
public class Facility {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACILITY_ID")
    private Long facilityId;

    /**
     */
    @Column(name = "FACILITY_NAME", columnDefinition = "char")
    @Size(min = 0, max = 90)
    private String facilityName;

    @Column(name = "FACILITY_CITY", columnDefinition = "char")
    @Size(min = 6, max = 20)
    private String facilityCity;
    
    @Column(name = "FACILITY_PROVINCE", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String facilityProvince;
    
    @Column(name = "FACILITY_POSTAL_CODE", columnDefinition = "char")
    @Size(min = 0, max = 6)
    private String facilityPostalCode;
    
    @Column(name = "FACILITY_ADDRESS", columnDefinition = "char")
    @Size(min = 0, max = 50)
    private String facilityAddress;
    
    @Column(name = "FACILITY_ADDRESS2", columnDefinition = "char")
    @Size(min = 0, max = 50)
    private String facilityAddress2;

    @Column(name = "FACILITY_FAX", columnDefinition = "NUMBER")    
    private Long facilityfax;
    
    @Column(name = "FACILITY_PHONE", columnDefinition = "NUMBER")    
    private Long facilityPhone;
    
    @Column(name = "FACILITY_EMAIL", columnDefinition = "char")
    @Size(min = 0, max = 40)
    private String facilityEmail;
}
