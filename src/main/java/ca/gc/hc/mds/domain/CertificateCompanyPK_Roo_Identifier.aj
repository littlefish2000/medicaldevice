// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.CertificateCompanyPK;
import java.math.BigDecimal;
import javax.persistence.Embeddable;

privileged aspect CertificateCompanyPK_Roo_Identifier {
    
    declare @type: CertificateCompanyPK: @Embeddable;
    
    public CertificateCompanyPK.new(String certificateId, BigDecimal companyAuthId) {
        super();
        this.certificateId = certificateId;
        this.companyAuthId = companyAuthId;
    }

    private CertificateCompanyPK.new() {
        super();
    }

    public String CertificateCompanyPK.getCertificateId() {
        return certificateId;
    }
    
    public BigDecimal CertificateCompanyPK.getCompanyAuthId() {
        return companyAuthId;
    }
    
}
