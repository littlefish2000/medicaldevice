// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.LicenseStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect LicenseStatus_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager LicenseStatus.entityManager;
    
    public static final List<String> LicenseStatus.fieldNames4OrderClauseFilter = java.util.Arrays.asList("licencestatusCd", "descr");
    
    public static final EntityManager LicenseStatus.entityManager() {
        EntityManager em = new LicenseStatus().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long LicenseStatus.countLicenseStatuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM LicenseStatus o", Long.class).getSingleResult();
    }
    
    public static List<LicenseStatus> LicenseStatus.findAllLicenseStatuses() {
        return entityManager().createQuery("SELECT o FROM LicenseStatus o", LicenseStatus.class).getResultList();
    }
    
    public static List<LicenseStatus> LicenseStatus.findAllLicenseStatuses(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM LicenseStatus o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, LicenseStatus.class).getResultList();
    }
    
    public static LicenseStatus LicenseStatus.findLicenseStatus(String licencestatusCd) {
        if (licencestatusCd == null || licencestatusCd.length() == 0) return null;
        return entityManager().find(LicenseStatus.class, licencestatusCd);
    }
    
    public static List<LicenseStatus> LicenseStatus.findLicenseStatusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM LicenseStatus o", LicenseStatus.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<LicenseStatus> LicenseStatus.findLicenseStatusEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM LicenseStatus o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, LicenseStatus.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void LicenseStatus.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void LicenseStatus.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            LicenseStatus attached = LicenseStatus.findLicenseStatus(this.licencestatusCd);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void LicenseStatus.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void LicenseStatus.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public LicenseStatus LicenseStatus.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        LicenseStatus merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
