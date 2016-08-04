package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB",table = "LICENCE_STATUS",identifierColumn = "LICENCE_STATUS_CD", 
identifierField = "licencestatusCd")
public class LicenseStatus {
	
    @Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "LICENCE_STATUS_CD", columnDefinition = "char",nullable=false, length=1)
    @Length(min=1,max = 1,message ="The value must be 1 character")
    private  String licencestatusCd;
    
    public String getLicencestatusCdCd() {
        return licencestatusCd;
    }    
    
    @Column(name = "DESCR", columnDefinition = "char",nullable=false, length=40)
    @Type(type = "fixedLengthCharType")
    @Length(max = 48,message ="The value must be less than 40 characters")
    private String descr;
    public String getDescr() {
        return descr;
    }    
}
