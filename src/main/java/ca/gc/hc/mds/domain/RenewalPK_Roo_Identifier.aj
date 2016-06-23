// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.RenewalPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embeddable;

privileged aspect RenewalPK_Roo_Identifier {
    
    declare @type: RenewalPK: @Embeddable;
    
    public RenewalPK.new(Date renewalRunDt, BigDecimal companyAuthId, BigDecimal companyId) {
        super();
        this.renewalRunDt = renewalRunDt;
        this.companyAuthId = companyAuthId;
        this.companyId = companyId;
    }

    private RenewalPK.new() {
        super();
    }

    public Date RenewalPK.getRenewalRunDt() {
        return renewalRunDt;
    }
    
    public BigDecimal RenewalPK.getCompanyAuthId() {
        return companyAuthId;
    }
    
    public BigDecimal RenewalPK.getCompanyId() {
        return companyId;
    }
    
}