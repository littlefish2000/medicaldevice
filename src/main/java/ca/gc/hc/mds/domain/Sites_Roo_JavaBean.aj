// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Sites;
import java.util.Date;

privileged aspect Sites_Roo_JavaBean {
    
    public void Sites.setStatus(String status) {
        this.status = status;
    }
    
    public Date Sites.getInitDt() {
        return this.initDt;
    }
    
    public void Sites.setInitDt(Date initDt) {
        this.initDt = initDt;
    }
    
    public Date Sites.getStatusDt() {
        return this.statusDt;
    }
    
    public void Sites.setStatusDt(Date statusDt) {
        this.statusDt = statusDt;
    }
    
}
