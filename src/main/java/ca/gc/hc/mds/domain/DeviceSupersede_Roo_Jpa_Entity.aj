// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DeviceSupersede;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect DeviceSupersede_Roo_Jpa_Entity {
    
    declare @type: DeviceSupersede: @Entity;
    
    declare @type: DeviceSupersede: @Table(schema = "MDSDB", name = "DEVICE_SUPERSEDE");
    
}
