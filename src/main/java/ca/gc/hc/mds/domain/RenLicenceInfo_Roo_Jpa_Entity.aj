// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.RenLicenceInfo;
import ca.gc.hc.mds.domain.RenLicenceInfoPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect RenLicenceInfo_Roo_Jpa_Entity {
    
    declare @type: RenLicenceInfo: @Entity;
    
    declare @type: RenLicenceInfo: @Table(schema = "MDSDB", name = "REN_LICENCE_INFO");
    
    @EmbeddedId
    private RenLicenceInfoPK RenLicenceInfo.id;
    
    public RenLicenceInfoPK RenLicenceInfo.getId() {
        return this.id;
    }
    
    public void RenLicenceInfo.setId(RenLicenceInfoPK id) {
        this.id = id;
    }
    
}
