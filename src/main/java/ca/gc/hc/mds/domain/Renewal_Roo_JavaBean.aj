// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Renewal;
import java.util.Calendar;

privileged aspect Renewal_Roo_JavaBean {
    
    public Calendar Renewal.getReceiptDt() {
        return this.receiptDt;
    }
    
    public void Renewal.setReceiptDt(Calendar receiptDt) {
        this.receiptDt = receiptDt;
    }
    
}