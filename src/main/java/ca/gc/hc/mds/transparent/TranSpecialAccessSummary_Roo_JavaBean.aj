// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.transparent;

import ca.gc.hc.mds.transparent.TranSpecialAccessSummary;
import java.util.Date;

privileged aspect TranSpecialAccessSummary_Roo_JavaBean {
    
    public Long TranSpecialAccessSummary.getId() {
        return this.id;
    }
    
    public void TranSpecialAccessSummary.setId(Long id) {
        this.id = id;
    }
    
    public Long TranSpecialAccessSummary.getSpecialAccessID() {
        return this.specialAccessID;
    }
    
    public void TranSpecialAccessSummary.setSpecialAccessID(Long specialAccessID) {
        this.specialAccessID = specialAccessID;
    }
    
    public Date TranSpecialAccessSummary.getRequestDate() {
        return this.requestDate;
    }
    
    public void TranSpecialAccessSummary.setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    public Date TranSpecialAccessSummary.getActionDate() {
        return this.actionDate;
    }
    
    public void TranSpecialAccessSummary.setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    
    public String TranSpecialAccessSummary.getActionTaken() {
        return this.actionTaken;
    }
    
    public void TranSpecialAccessSummary.setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }
    
    public String TranSpecialAccessSummary.getDeviceIdentifier() {
        return this.deviceIdentifier;
    }
    
    public void TranSpecialAccessSummary.setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }
    
}
