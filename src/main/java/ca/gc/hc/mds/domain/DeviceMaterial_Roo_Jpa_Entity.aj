// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DeviceMaterial;
import ca.gc.hc.mds.domain.DeviceMaterialPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect DeviceMaterial_Roo_Jpa_Entity {
    
    declare @type: DeviceMaterial: @Entity;
    
    declare @type: DeviceMaterial: @Table(schema = "MDSDB", name = "DEVICE_MATERIALS");
    
    @EmbeddedId
    private DeviceMaterialPK DeviceMaterial.id;
    
    public DeviceMaterialPK DeviceMaterial.getId() {
        return this.id;
    }
    
    public void DeviceMaterial.setId(DeviceMaterialPK id) {
        this.id = id;
    }
    
}
