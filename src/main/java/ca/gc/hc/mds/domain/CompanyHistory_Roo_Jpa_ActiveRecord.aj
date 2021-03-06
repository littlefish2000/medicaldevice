// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.CompanyHistory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CompanyHistory_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CompanyHistory.entityManager;
    
    public static final List<String> CompanyHistory.fieldNames4OrderClauseFilter = java.util.Arrays.asList("companyHistoryId", "changeDate", "companyName", "addressLine1", "addressLine2", "addressLine3", "addressLine4", "addressLine5", "postCode", "regionCode", "city", "country", "region", "companyStatus", "feeReduction", "grossRevenue", "mdbBillTo", "company");
    
    public static final EntityManager CompanyHistory.entityManager() {
        EntityManager em = new CompanyHistory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CompanyHistory.countCompanyHistorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CompanyHistory o", Long.class).getSingleResult();
    }
    
    public static List<CompanyHistory> CompanyHistory.findAllCompanyHistorys() {
        return entityManager().createQuery("SELECT o FROM CompanyHistory o", CompanyHistory.class).getResultList();
    }
    
    public static List<CompanyHistory> CompanyHistory.findAllCompanyHistorys(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CompanyHistory o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CompanyHistory.class).getResultList();
    }
    
    public static CompanyHistory CompanyHistory.findCompanyHistory(Long companyHistoryId) {
        if (companyHistoryId == null) return null;
        return entityManager().find(CompanyHistory.class, companyHistoryId);
    }
    
    public static List<CompanyHistory> CompanyHistory.findCompanyHistoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CompanyHistory o", CompanyHistory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CompanyHistory> CompanyHistory.findCompanyHistoryEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CompanyHistory o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CompanyHistory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CompanyHistory.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CompanyHistory.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CompanyHistory attached = CompanyHistory.findCompanyHistory(this.companyHistoryId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CompanyHistory.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CompanyHistory.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CompanyHistory CompanyHistory.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CompanyHistory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
