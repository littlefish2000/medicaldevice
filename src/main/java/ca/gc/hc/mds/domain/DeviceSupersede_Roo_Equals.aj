// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DeviceSupersede;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect DeviceSupersede_Roo_Equals {
    
    public boolean DeviceSupersede.equals(Object obj) {
        if (!(obj instanceof DeviceSupersede)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DeviceSupersede rhs = (DeviceSupersede) obj;
        return new EqualsBuilder().append(superSededID, rhs.superSededID).append(superSedesID, rhs.superSedesID).isEquals();
    }
    
    public int DeviceSupersede.hashCode() {
        return new HashCodeBuilder().append(superSededID).append(superSedesID).toHashCode();
    }
    
}