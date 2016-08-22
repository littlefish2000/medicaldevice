// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.CompanyContact;
import ca.gc.hc.mds.domain.CompanyHistory;
import ca.gc.hc.mds.reference.StatusType;
import ca.gc.hc.mds.reference.YesAndNoType;
import java.util.Date;
import java.util.Set;

privileged aspect Company_Roo_JavaBean {
    
    public Long Company.getCompanyId() {
        return this.companyId;
    }
    
    public void Company.setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    
    public void Company.setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public void Company.setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    
    public void Company.setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    
    public void Company.setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
    
    public void Company.setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }
    
    public void Company.setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }
    
    public void Company.setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String Company.getRegionCode() {
        return this.regionCode;
    }
    
    public void Company.setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    
    public String Company.getCity() {
        return this.city;
    }
    
    public void Company.setCity(String city) {
        this.city = city;
    }
    
    public String Company.getCountry() {
        return this.country;
    }
    
    public void Company.setCountry(String country) {
        this.country = country;
    }
    
    public String Company.getRegion() {
        return this.region;
    }
    
    public void Company.setRegion(String region) {
        this.region = region;
    }
    
    public StatusType Company.getCompanyStatus() {
        return this.companyStatus;
    }
    
    public void Company.setCompanyStatus(StatusType companyStatus) {
        this.companyStatus = companyStatus;
    }
    
    public Date Company.getStatusDate() {
        return this.statusDate;
    }
    
    public void Company.setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
    
    public String Company.getTaxNumber1() {
        return this.taxNumber1;
    }
    
    public void Company.setTaxNumber1(String taxNumber1) {
        this.taxNumber1 = taxNumber1;
    }
    
    public String Company.getTaxNumber4() {
        return this.taxNumber4;
    }
    
    public void Company.setTaxNumber4(String taxNumber4) {
        this.taxNumber4 = taxNumber4;
    }
    
    public Long Company.getBillToId() {
        return this.billToId;
    }
    
    public void Company.setBillToId(Long billToId) {
        this.billToId = billToId;
    }
    
    public Long Company.getContactId() {
        return this.contactId;
    }
    
    public void Company.setContactId(Long contactId) {
        this.contactId = contactId;
    }
    
    public String Company.getIndustry() {
        return this.industry;
    }
    
    public void Company.setIndustry(String industry) {
        this.industry = industry;
    }
    
    public String Company.getCommonMethod() {
        return this.commonMethod;
    }
    
    public void Company.setCommonMethod(String commonMethod) {
        this.commonMethod = commonMethod;
    }
    
    public Date Company.getLastChangeDate() {
        return this.lastChangeDate;
    }
    
    public void Company.setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
    
    public YesAndNoType Company.getNewreg89() {
        return this.newreg89;
    }
    
    public void Company.setNewreg89(YesAndNoType newreg89) {
        this.newreg89 = newreg89;
    }
    
    public YesAndNoType Company.getFeeReduction() {
        return this.feeReduction;
    }
    
    public void Company.setFeeReduction(YesAndNoType feeReduction) {
        this.feeReduction = feeReduction;
    }
    
    public Set<CompanyContact> Company.getContacts() {
        return this.contacts;
    }
    
    public void Company.setContacts(Set<CompanyContact> contacts) {
        this.contacts = contacts;
    }
    
    public Set<CompanyHistory> Company.getHistorys() {
        return this.historys;
    }
    
    public void Company.setHistorys(Set<CompanyHistory> historys) {
        this.historys = historys;
    }
    
}
