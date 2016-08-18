package ca.gc.hc.mds.domain;
import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",table = "MANUFACTURERS",identifierType = ManufacturersPK.class)
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class Manufacturers {
	
	@Column(name = "STATUS", columnDefinition = "char(1)") 
	@Type(type = "fixedLengthCharType")
	private String status;
    public String getStatus() {
        return status;
    }  	
}
