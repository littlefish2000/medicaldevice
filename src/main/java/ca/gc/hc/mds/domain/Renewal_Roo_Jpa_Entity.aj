// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Renewal;
import ca.gc.hc.mds.domain.RenewalPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Renewal_Roo_Jpa_Entity {
    
    declare @type: Renewal: @Entity;
    
    declare @type: Renewal: @Table(schema = "MDSDB", name = "RENEWAL");
    
    @EmbeddedId
    private RenewalPK Renewal.id;
    
    public RenewalPK Renewal.getId() {
        return this.id;
    }
    
    public void Renewal.setId(RenewalPK id) {
        this.id = id;
    }
    
}
