// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DeviceDerivatives;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect DeviceDerivatives_Roo_Jpa_Entity {
    
    declare @type: DeviceDerivatives: @Entity;
    
    declare @type: DeviceDerivatives: @Table(schema = "MDSDB", name = "DEVICE_DERIVATIVES");
    
}
