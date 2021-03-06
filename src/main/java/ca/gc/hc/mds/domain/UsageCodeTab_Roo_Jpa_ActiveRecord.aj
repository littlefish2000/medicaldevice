// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.UsageCodeTab;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UsageCodeTab_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager UsageCodeTab.entityManager;
    
    public static final List<String> UsageCodeTab.fieldNames4OrderClauseFilter = java.util.Arrays.asList("usageCode", "descENG", "descFR");
    
    public static final EntityManager UsageCodeTab.entityManager() {
        EntityManager em = new UsageCodeTab().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long UsageCodeTab.countUsageCodeTabs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UsageCodeTab o", Long.class).getSingleResult();
    }
    
    public static List<UsageCodeTab> UsageCodeTab.findAllUsageCodeTabs() {
        return entityManager().createQuery("SELECT o FROM UsageCodeTab o", UsageCodeTab.class).getResultList();
    }
    
    public static List<UsageCodeTab> UsageCodeTab.findAllUsageCodeTabs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UsageCodeTab o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UsageCodeTab.class).getResultList();
    }
    
    public static UsageCodeTab UsageCodeTab.findUsageCodeTab(String usageCode) {
        if (usageCode == null || usageCode.length() == 0) return null;
        return entityManager().find(UsageCodeTab.class, usageCode);
    }
    
    public static List<UsageCodeTab> UsageCodeTab.findUsageCodeTabEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UsageCodeTab o", UsageCodeTab.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<UsageCodeTab> UsageCodeTab.findUsageCodeTabEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM UsageCodeTab o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, UsageCodeTab.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void UsageCodeTab.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void UsageCodeTab.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            UsageCodeTab attached = UsageCodeTab.findUsageCodeTab(this.usageCode);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void UsageCodeTab.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void UsageCodeTab.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public UsageCodeTab UsageCodeTab.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UsageCodeTab merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
