// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.CertificateCompanyPK;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect CertificateCompanyPK_Roo_Equals {
    
    public boolean CertificateCompanyPK.equals(Object obj) {
        if (!(obj instanceof CertificateCompanyPK)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CertificateCompanyPK rhs = (CertificateCompanyPK) obj;
        return new EqualsBuilder().append(certificateId, rhs.certificateId).append(companyAuthId, rhs.companyAuthId).isEquals();
    }
    
    public int CertificateCompanyPK.hashCode() {
        return new HashCodeBuilder().append(certificateId).append(companyAuthId).toHashCode();
    }
    
}