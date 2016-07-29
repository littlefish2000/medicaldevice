package ca.gc.hc.mds.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "REGISTRAR_CD", 
identifierField = "registrarCd",  table = "REGISTRAR")
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class Registrar {
	@Id
	@Type(type = "fixedLengthCharType")
	@Column(name = "REGISTRAR_CD", columnDefinition = "char(7)") 
	private String registrarCd;

    public String getRegistrarCd() {
        return registrarCd;
    }   
	
	@Column(name = "REGISTRAR_NAME", columnDefinition = "char(90)") 
	private String registrarName;
	
	@Column(name = "ADDR_LINE_1", columnDefinition = "char(35)") 
	private String addrLine1;
	
	@Column(name = "ADDR_LINE_2", columnDefinition = "char(35)") 
	private String addrLine2;
	
	@Column(name = "ADDR_LINE_3", columnDefinition = "char(35)") 
	private String addrline3;
	
	@Column(name = "POSTAL_CODE", columnDefinition = "char(12)") 
	private String postalCode;
	
	@Column(name = "CITY", columnDefinition = "char(35)") 
	private String city;
	
	@Column(name = "COUNTRY_CD", columnDefinition = "char(2)") 
	private String countryCd;
	
	@Column(name = "REGION_CD", columnDefinition = "char(3)") 
	private String regionCd;
	
	@Column(name = "STATUS", columnDefinition = "char(1)") 
	private String status;
	
	@Column(name = "STATUS_DT", columnDefinition = "DATE") 
	@DateTimeFormat(style="M-")
	private Date statusDt;
	
	@Column(name = "REGISTRAR_WEB", columnDefinition = "char(40)") 
	private String registrarWeb;
	
	@Column(name = "VALIDATION_FAX", columnDefinition = "NUMBER") 
	private String validationFax;
	
	@Column(name = "VALIDATION_PHONE", columnDefinition = "NUMBER") 
	private String validationPhone;
	
	@Column(name = "VALIDATION_EMAIL", columnDefinition = "char(40)") 
	private String validationEmail;
	
	@Column(name = "VALIDATION_CONTACT", columnDefinition = "char(50)") 
	private String validationContact;
	
	@Column(name = "VALIDATION_POSITION", columnDefinition = "char(40)") 
	private String validationPosition;
	
	@Column(name = "CMDCAS_FAX", columnDefinition = "NUMBER") 
	private String cmdcasFax;
	
	@Column(name = "CMDCAS_PHONE", columnDefinition = "NUMBER") 
	private String cmdcasPhone;
	
	@Column(name = "CMDCAS_EMAIL", columnDefinition = "char(40)") 
	private String cmdcasEmail;
	
	@Column(name = "CMDCAS_CONTACT", columnDefinition = "char(50)") 
	private String cmdcasContact;
	
	@Column(name = "CMDCAS_POSITION", columnDefinition = "char(40)") 
	private String cmdcasPosition;	
}
