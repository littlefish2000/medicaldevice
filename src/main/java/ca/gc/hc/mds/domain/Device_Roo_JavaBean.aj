// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Device;
import java.util.Date;

privileged aspect Device_Roo_JavaBean {
    
    public Long Device.getDeviceId() {
        return this.deviceId;
    }
    
    public void Device.setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    
    public String Device.getTradeName() {
        return this.tradeName;
    }
    
    public void Device.setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
    
    public String Device.getPerfnameCode() {
        return this.perfnameCode;
    }
    
    public void Device.setPerfnameCode(String perfnameCode) {
        this.perfnameCode = perfnameCode;
    }
    
    public Date Device.getEntryDate() {
        return this.entryDate;
    }
    
    public void Device.setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    public Date Device.getLastChangeDate() {
        return this.lastChangeDate;
    }
    
    public void Device.setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
    
}
