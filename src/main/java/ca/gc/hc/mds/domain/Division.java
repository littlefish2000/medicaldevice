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
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "DIVISION_CD", 
identifierField = "divisionCd",table = "DIVISION", finders =
{"findDivisionsByDivisionCd"})
public class Division {
    @Id
    @Type(type = "fixedLengthCharType")
    @Column(name = "DIVISION_CD", columnDefinition = "char",nullable=false, length=3)
    @Length(min=1,max = 3,message ="The value must be 1-3 characters")
    private  String divisionCd;
    

    
    @Column(name = "DIVISION_DESC", columnDefinition = "char",nullable=false, length=35)
    @Type(type = "fixedLengthCharType")
    @Length(min=0,max = 35,message ="The value must be 0-35 characters")
    private String divisionDesc;
    public String getDivisionDesc() {
        return divisionDesc;
    }    
}
