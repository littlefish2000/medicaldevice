package ca.gc.hc.mds.domain;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

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

@RooToString
@RooEquals
@RooIdentifier
public class RenAuthCompanyPK  implements Serializable{
	
    @Column(name = "RENEWAL_RUN_DT", nullable = false)
    private Calendar renewalRunDt;
    
    @Column(name = "COMPANY_AUTH_ID", nullable = false)
    private BigDecimal companyAuthId;
    
}
