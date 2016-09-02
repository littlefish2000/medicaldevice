// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.ApplicationHistory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ApplicationHistory_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ApplicationHistory.entityManager;
    
    public static final List<String> ApplicationHistory.fieldNames4OrderClauseFilter = java.util.Arrays.asList("applicationHistId", "applicationId", "applicationStatus", "startDt", "endDt", "evaluator", "operator", "historyComments");
    
    public static final EntityManager ApplicationHistory.entityManager() {
        EntityManager em = new ApplicationHistory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ApplicationHistory.countApplicationHistorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ApplicationHistory o", Long.class).getSingleResult();
    }
    
    public static List<ApplicationHistory> ApplicationHistory.findAllApplicationHistorys() {
        return entityManager().createQuery("SELECT o FROM ApplicationHistory o", ApplicationHistory.class).getResultList();
    }
    
    public static List<ApplicationHistory> ApplicationHistory.findAllApplicationHistorys(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ApplicationHistory o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ApplicationHistory.class).getResultList();
    }
    
    public static ApplicationHistory ApplicationHistory.findApplicationHistory(Long applicationHistId) {
        if (applicationHistId == null) return null;
        return entityManager().find(ApplicationHistory.class, applicationHistId);
    }
    
    public static List<ApplicationHistory> ApplicationHistory.findApplicationHistoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ApplicationHistory o", ApplicationHistory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<ApplicationHistory> ApplicationHistory.findApplicationHistoryEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ApplicationHistory o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ApplicationHistory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ApplicationHistory.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ApplicationHistory.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ApplicationHistory attached = ApplicationHistory.findApplicationHistory(this.applicationHistId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ApplicationHistory.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ApplicationHistory.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ApplicationHistory ApplicationHistory.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ApplicationHistory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}