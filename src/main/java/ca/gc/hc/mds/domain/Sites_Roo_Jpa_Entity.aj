// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Sites;
import ca.gc.hc.mds.domain.SitesPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Sites_Roo_Jpa_Entity {
    
    declare @type: Sites: @Entity;
    
    declare @type: Sites: @Table(schema = "MDSDB", name = "SITES");
    
    @EmbeddedId
    private SitesPK Sites.id;
    
    public SitesPK Sites.getId() {
        return this.id;
    }
    
    public void Sites.setId(SitesPK id) {
        this.id = id;
    }
    
}
