package ca.gc.hc.mds.domain;
import org.springframework.beans.factory.annotation.Configurable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configurable
@Embeddable
public class RenAuthCompanyPK  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Column(name = "RENEWAL_RUN_DT", nullable = false)
    private Calendar renewalRunDt;
    
    @Column(name = "COMPANY_AUTH_ID", nullable = false)
    private BigDecimal companyAuthId;
    
    public RenAuthCompanyPK(Calendar renewalRunDt, BigDecimal companyAuthId) {
        super();
        this.renewalRunDt = renewalRunDt;
        this.companyAuthId = companyAuthId;
    }

    public RenAuthCompanyPK() {
        super();
    }

    public Calendar getRenewalRunDt() {
        return renewalRunDt;
    }
    
    public BigDecimal getCompanyAuthId() {
        return companyAuthId;
    }
    
    public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static RenAuthCompanyPK fromJsonToRenAuthCompanyPK(String json) {
        return new JSONDeserializer<RenAuthCompanyPK>()
        .use(null, RenAuthCompanyPK.class).deserialize(json);
    }
    
    public static String toJsonArray(Collection<RenAuthCompanyPK> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String toJsonArray(Collection<RenAuthCompanyPK> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<RenAuthCompanyPK> fromJsonArrayToRenAuthCompanyPKs(String json) {
        return new JSONDeserializer<List<RenAuthCompanyPK>>()
        .use("values", RenAuthCompanyPK.class).deserialize(json);
    }    
}
