// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Correspondence;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Correspondence_Roo_Jpa_Entity {
    
    declare @type: Correspondence: @Entity;
    
    declare @type: Correspondence: @Table(schema = "MDSDB", name = "CORRESPONDENCE");
    
}
