// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.CountryRegionTabPK;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect CountryRegionTabPK_Roo_Equals {
    
    public boolean CountryRegionTabPK.equals(Object obj) {
        if (!(obj instanceof CountryRegionTabPK)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CountryRegionTabPK rhs = (CountryRegionTabPK) obj;
        return new EqualsBuilder().append(countryCD, rhs.countryCD).append(regionCD, rhs.regionCD).isEquals();
    }
    
    public int CountryRegionTabPK.hashCode() {
        return new HashCodeBuilder().append(countryCD).append(regionCD).toHashCode();
    }
    
}