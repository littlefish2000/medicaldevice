package ca.gc.hc.mds.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierColumn = "APPLICATION_ID", identifierField = "id", table = "APPLICATION", finders = { "findApplicationsByApplcationNameLike", "findApplicationsById" })
public class Application {

    /**
     */
    @Column(name = "APPLICATION_DESC")
    @Size(min = 3, max = 30)
    private String applicationDesc;

    /**
     */
    @NotNull
    @Column(name = "APPLICATION_NAME")
    @Size(min = 3, max = 30)
    private String applcationName;
}
