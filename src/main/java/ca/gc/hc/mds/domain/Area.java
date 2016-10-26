package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "AREA_CD", 
identifierField = "areaCd",table = "AREA", finders ={"findAreasByAreaCd"})
public class Area {

	    @Id
	    @Type(type = "fixedLengthCharType")
	    @Column(name = "AREA_CD", columnDefinition = "char",nullable=false, length=3)
	    @Length(min=1,max = 3,message ="The value must be 1-3 characters")
	    private  String areaCd;
	    

	    
	    @Column(name = "AREA_DESC", columnDefinition = "char",nullable=false, length=50)
	    @Type(type = "fixedLengthCharType")
	    @Length(min=0,max = 50,message ="The value must be 0-50 characters")
	    private String areaDesc;
}
