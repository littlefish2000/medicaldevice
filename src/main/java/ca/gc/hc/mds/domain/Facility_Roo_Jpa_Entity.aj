// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Facility;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Facility_Roo_Jpa_Entity {
    
    declare @type: Facility: @Entity;
    
    declare @type: Facility: @Table(schema = "MDSDB", name = "FACILITY");
    
}
