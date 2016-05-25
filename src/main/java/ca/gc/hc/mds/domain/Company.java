package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierColumn = "COMPANY_ID", identifierField = "companyId", table = "COMPANY", finders = { "findCompanysByCompanyNameLike" })
public class Company {

    /**
     */
    @Column(name = "COMPANY_NAME")
    @Size(min = 0, max = 90)
    private String companyName;

    /**
     */
    @Column(name = "ADDR_LINE_1")
    @Size(min = 0, max = 45)
    private String addressLine1;

    /**
     */
    @Column(name = "ADDR_LINE_2")
    @Size(min = 0, max = 45)
    private String addressLine2;

    /**
     */
    @Column(name = "POSTAL_CODE")
    @Size(min = 0, max = 12)
    private String postCode;

    /**
     */
    @Column(name = "CITY")
    @Size(min = 0, max = 35)
    private String city;
}
