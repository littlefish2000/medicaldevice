// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.RenAuthCompanyPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embeddable;

privileged aspect RenAuthCompanyPK_Roo_Identifier {
    
    declare @type: RenAuthCompanyPK: @Embeddable;
    
    public RenAuthCompanyPK.new(Date renewalRunDt, BigDecimal companyAuthId) {
        super();
        this.renewalRunDt = renewalRunDt;
        this.companyAuthId = companyAuthId;
    }

    private RenAuthCompanyPK.new() {
        super();
    }

    public Date RenAuthCompanyPK.getRenewalRunDt() {
        return renewalRunDt;
    }
    
    public BigDecimal RenAuthCompanyPK.getCompanyAuthId() {
        return companyAuthId;
    }
    
}
