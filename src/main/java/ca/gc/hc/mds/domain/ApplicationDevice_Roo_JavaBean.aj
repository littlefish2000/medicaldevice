// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.ApplicationDevice;
import java.util.Date;

privileged aspect ApplicationDevice_Roo_JavaBean {
    
    public String ApplicationDevice.getAppldeviceStatus() {
        return this.appldeviceStatus;
    }
    
    public void ApplicationDevice.setAppldeviceStatus(String appldeviceStatus) {
        this.appldeviceStatus = appldeviceStatus;
    }
    
    public Date ApplicationDevice.getStatusDate() {
        return this.statusDate;
    }
    
    public void ApplicationDevice.setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
    
    public String ApplicationDevice.getEvaluationRequired() {
        return this.evaluationRequired;
    }
    
    public void ApplicationDevice.setEvaluationRequired(String evaluationRequired) {
        this.evaluationRequired = evaluationRequired;
    }
    
    public Date ApplicationDevice.getLicenceDate() {
        return this.licenceDate;
    }
    
    public void ApplicationDevice.setLicenceDate(Date licenceDate) {
        this.licenceDate = licenceDate;
    }
    
}
