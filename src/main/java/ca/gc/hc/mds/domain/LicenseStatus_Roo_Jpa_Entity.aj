// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.LicenseStatus;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect LicenseStatus_Roo_Jpa_Entity {
    
    declare @type: LicenseStatus: @Entity;
    
    declare @type: LicenseStatus: @Table(schema = "MDSDB", name = "LICENCE_STATUS");
    
}