// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Area;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Area_Roo_Jpa_Entity {
    
    declare @type: Area: @Entity;
    
    declare @type: Area: @Table(schema = "MDSDB", name = "AREA");
    
}