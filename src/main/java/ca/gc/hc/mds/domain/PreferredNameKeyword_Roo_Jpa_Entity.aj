// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.PreferredNameKeyword;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect PreferredNameKeyword_Roo_Jpa_Entity {
    
    declare @type: PreferredNameKeyword: @Entity;
    
    declare @type: PreferredNameKeyword: @Table(schema = "MDSDB", name = "PREF_DESC_TAB");
    
}
