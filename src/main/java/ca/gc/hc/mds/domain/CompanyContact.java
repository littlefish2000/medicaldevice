package ca.gc.hc.mds.domain;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.Size;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "COMPANY_CONTACT", schema = "MDSDB", identifierColumn = "COMPANY_CONTACT_ID", identifierField = "companyContactId", finders = {
        "findCompanyContactsByCompany" })
public class CompanyContact {

    @TableGenerator(name = "COMPANYCONTACT_GENERATOR", table = "CONTROL_TEST", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "COMPANY_CONTACT_ID", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "COMPANYCONTACT_GENERATOR")
    @Column(name = "COMPANY_CONTACT_ID")
    private Long companyContactId;

    @Type(type = "fixedLengthCharType")
    @Column(name = "CONTACT_TYPE", nullable = false, length = 1, columnDefinition = "char(1) default ' '")
    private String contactType = "";
    
    @Type(type = "fixedLengthCharType")
    @Column(name = "CONTACT_STATUS", nullable = false, length = 1, columnDefinition = "char(1) default ' '")
    private String contactStatus = "A";      
    
    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;
    
    @Column(name = "CONTACT_NAME", nullable = false, length = 45, columnDefinition = "char")
    private String contactName;

    @Column(name = "CONTACT_TITLE", nullable = false, length = 45, columnDefinition = "char")
    private String contactTitle;

    @Column(name = "CONTACT_PHONE", columnDefinition = "NUMBER")
    private String contactPhone;

    @Column(name = "CONTACT_EXT", columnDefinition = "NUMBER")
    private String contactExt;

    @Column(name = "CONTACT_FAX", columnDefinition = "NUMBER")
    private String contactFax;

    @Column(name = "E_MAIL", nullable = false, length = 70, columnDefinition = "char")
    private String e_MAIL = "";

    @Column(name = "LANGUAGE", columnDefinition = "char")
    private String language = "E";

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
    @JoinColumns({ @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", nullable = false) })
    // @org.hibernate.annotations.Index(name="COMP_CON_IDX")
    private Company company;

    @PrePersist
    void preInsert() {

        preUpdateValuesWithWhiteSpace();
        StringUtils.trim(contactType);
        StringUtils.trim(contactStatus);
        
    }

    @PreUpdate
    void preUpdate() {
        preUpdateValuesWithWhiteSpace();
    }   
    
    protected void preUpdateValuesWithWhiteSpace() {
        StringUtils.rightPad(contactType,1);
        StringUtils.rightPad(contactStatus,1);      
        StringUtils.rightPad(contactName,45);
        StringUtils.rightPad(contactTitle, 45);
    }
}
