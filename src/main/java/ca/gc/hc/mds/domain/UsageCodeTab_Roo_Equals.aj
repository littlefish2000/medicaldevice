// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.UsageCodeTab;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect UsageCodeTab_Roo_Equals {
    
    public boolean UsageCodeTab.equals(Object obj) {
        if (!(obj instanceof UsageCodeTab)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UsageCodeTab rhs = (UsageCodeTab) obj;
        return new EqualsBuilder().append(descENG, rhs.descENG).append(descFR, rhs.descFR).append(usageCode, rhs.usageCode).isEquals();
    }
    
    public int UsageCodeTab.hashCode() {
        return new HashCodeBuilder().append(descENG).append(descFR).append(usageCode).toHashCode();
    }
    
}
