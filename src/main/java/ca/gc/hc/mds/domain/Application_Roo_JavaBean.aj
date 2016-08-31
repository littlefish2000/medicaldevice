// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.ApplAmendmentReason;
import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.LicIntendedIndicationUse;
import java.util.Date;

privileged aspect Application_Roo_JavaBean {
    
    public Long Application.getApplicationId() {
        return this.applicationId;
    }
    
    public void Application.setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    public long Application.getOrginLicenseId() {
        return this.orginLicenseId;
    }
    
    public void Application.setOrginLicenseId(long orginLicenseId) {
        this.orginLicenseId = orginLicenseId;
    }
    
    public Date Application.getEntryDate() {
        return this.entryDate;
    }
    
    public void Application.setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    public Date Application.getReceiptDate() {
        return this.receiptDate;
    }
    
    public void Application.setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
    
    public String Application.getApplicationDesc() {
        return this.applicationDesc;
    }
    
    public void Application.setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }
    
    public String Application.getApplicationComments() {
        return this.applicationComments;
    }
    
    public void Application.setApplicationComments(String applicationComments) {
        this.applicationComments = applicationComments;
    }
    
    public String Application.getLicenceName() {
        return this.licenceName;
    }
    
    public void Application.setLicenceName(String licenceName) {
        this.licenceName = licenceName;
    }
    
    public String Application.getApplicationType() {
        return this.applicationType;
    }
    
    public void Application.setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
    
    public String Application.getDevLicenceType() {
        return this.devLicenceType;
    }
    
    public void Application.setDevLicenceType(String devLicenceType) {
        this.devLicenceType = devLicenceType;
    }
    
    public Long Application.getCompanyAuthId() {
        return this.companyAuthId;
    }
    
    public void Application.setCompanyAuthId(Long companyAuthId) {
        this.companyAuthId = companyAuthId;
    }
    
    public Long Application.getAppRiskClass() {
        return this.appRiskClass;
    }
    
    public void Application.setAppRiskClass(Long appRiskClass) {
        this.appRiskClass = appRiskClass;
    }
    
    public Long Application.getCompanyId() {
        return this.companyId;
    }
    
    public void Application.setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    
    public String Application.getDivisionCd() {
        return this.divisionCd;
    }
    
    public void Application.setDivisionCd(String divisionCd) {
        this.divisionCd = divisionCd;
    }
    
    public String Application.getDeviceDrug() {
        return this.deviceDrug;
    }
    
    public void Application.setDeviceDrug(String deviceDrug) {
        this.deviceDrug = deviceDrug;
    }
    
    public String Application.getPointOfCare() {
        return this.pointOfCare;
    }
    
    public void Application.setPointOfCare(String pointOfCare) {
        this.pointOfCare = pointOfCare;
    }
    
    public String Application.getHomeUseCode() {
        return this.homeUseCode;
    }
    
    public void Application.setHomeUseCode(String homeUseCode) {
        this.homeUseCode = homeUseCode;
    }
    
    public String Application.getDisclosureFlag() {
        return this.disclosureFlag;
    }
    
    public void Application.setDisclosureFlag(String disclosureFlag) {
        this.disclosureFlag = disclosureFlag;
    }
    
    public String Application.getNearPatient() {
        return this.nearPatient;
    }
    
    public void Application.setNearPatient(String nearPatient) {
        this.nearPatient = nearPatient;
    }
    
    public LicIntendedIndicationUse Application.getIntendedIndication() {
        return this.intendedIndication;
    }
    
    public void Application.setIntendedIndication(LicIntendedIndicationUse intendedIndication) {
        this.intendedIndication = intendedIndication;
    }
    
    public ApplAmendmentReason Application.getAmendmentReason() {
        return this.amendmentReason;
    }
    
    public void Application.setAmendmentReason(ApplAmendmentReason amendmentReason) {
        this.amendmentReason = amendmentReason;
    }
    
}
