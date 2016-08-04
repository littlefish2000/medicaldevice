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
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "DEVICE_IDENT_CONTENT_CD", 
identifierField = "deviceidentcontentCd",table = "DEVICE_IDENT_CONTENT")
public class DeviceIndentContent {
    @Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "DEVICE_IDENT_CONTENT_CD", columnDefinition = "char",nullable=false, length=4)
    @Length(min=1,max = 4,message ="The value must be 1-4 characters")
    private  String deviceidentcontentCd;
    
    public String getDeviceidentcontentCd() {
        return deviceidentcontentCd;
    }    
    
    @Column(name = "DESCR", columnDefinition = "char",nullable=false, length=40)
    @Type(type = "fixedLengthCharType")
    @Length(min=0,max = 40,message ="The value must be 0-40 characters")
    private String descr;
    public String getDescr() {
        return descr;
    }    	
}
