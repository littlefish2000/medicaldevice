// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.ManufacturersPK;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect ManufacturersPK_Roo_Equals {
    
    public boolean ManufacturersPK.equals(Object obj) {
        if (!(obj instanceof ManufacturersPK)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ManufacturersPK rhs = (ManufacturersPK) obj;
        return new EqualsBuilder().append(establishmentId, rhs.establishmentId).append(mfgId, rhs.mfgId).isEquals();
    }
    
    public int ManufacturersPK.hashCode() {
        return new HashCodeBuilder().append(establishmentId).append(mfgId).toHashCode();
    }
    
}
