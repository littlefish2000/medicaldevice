// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.UsageCodeTab;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect UsageCodeTab_Roo_Jpa_Entity {
    
    declare @type: UsageCodeTab: @Entity;
    
    declare @type: UsageCodeTab: @Table(schema = "MDSDB", name = "USAGE_CODE_TAB");
    
}
