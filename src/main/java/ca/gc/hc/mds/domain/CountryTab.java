package ca.gc.hc.mds.domain;
import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "COUNTRY_CD", 
identifierField = "countryCd",  table = "COUNTRY_TAB")
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class CountryTab {
	
    @Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "COUNTRY_CD", columnDefinition = "char",nullable=false, length=2)
    private  String countryCd;
    
    public String getCountryCdCd() {
        return countryCd;
    }    
    
    @Column(name = "COUNTRY_DESC", columnDefinition = "char",nullable=false, length=25)
    @Type(type = "fixedLengthCharType")
    private String countryDesc;
    public String getcountryDesc() {
        return countryDesc;
    }    
    	
}
