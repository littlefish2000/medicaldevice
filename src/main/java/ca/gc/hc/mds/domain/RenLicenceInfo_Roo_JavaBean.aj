// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.RenLicenceInfo;
import ca.gc.hc.mds.reference.LicenceStatusType;
import java.util.Date;

privileged aspect RenLicenceInfo_Roo_JavaBean {
    
    public String RenLicenceInfo.getLicenceName() {
        return this.licenceName;
    }
    
    public void RenLicenceInfo.setLicenceName(String licenceName) {
        this.licenceName = licenceName;
    }
    
    public Date RenLicenceInfo.getDateIssued() {
        return this.dateIssued;
    }
    
    public void RenLicenceInfo.setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }
    
    public Date RenLicenceInfo.getReceiptDt() {
        return this.receiptDt;
    }
    
    public void RenLicenceInfo.setReceiptDt(Date receiptDt) {
        this.receiptDt = receiptDt;
    }
    
    public Date RenLicenceInfo.getPostDt() {
        return this.postDt;
    }
    
    public void RenLicenceInfo.setPostDt(Date postDt) {
        this.postDt = postDt;
    }
    
    public Date RenLicenceInfo.getInvoiceDt() {
        return this.invoiceDt;
    }
    
    public void RenLicenceInfo.setInvoiceDt(Date invoiceDt) {
        this.invoiceDt = invoiceDt;
    }
    
    public LicenceStatusType RenLicenceInfo.getLicenceStatus() {
        return this.licenceStatus;
    }
    
    public void RenLicenceInfo.setLicenceStatus(LicenceStatusType licenceStatus) {
        this.licenceStatus = licenceStatus;
    }
    
}
