// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.LicenceStatusTracking;
import ca.gc.hc.mds.domain.LicenceStatusTrackingPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect LicenceStatusTracking_Roo_Jpa_Entity {
    
    declare @type: LicenceStatusTracking: @Entity;
    
    declare @type: LicenceStatusTracking: @Table(schema = "MDSDB", name = "LICENCE_STATUS_TRACKING");
    
    @EmbeddedId
    private LicenceStatusTrackingPK LicenceStatusTracking.id;
    
    public LicenceStatusTrackingPK LicenceStatusTracking.getId() {
        return this.id;
    }
    
    public void LicenceStatusTracking.setId(LicenceStatusTrackingPK id) {
        this.id = id;
    }
    
}
