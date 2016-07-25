// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.PreferredNameCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PreferredNameCode_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager PreferredNameCode.entityManager;
    
    public static final List<String> PreferredNameCode.fieldNames4OrderClauseFilter = java.util.Arrays.asList("prefNameCode", "prefDescEng1", "prefDescEng2", "prefDescFr1", "prefDescFr2", "riskClassification", "regulatedBy");
    
    public static final EntityManager PreferredNameCode.entityManager() {
        EntityManager em = new PreferredNameCode().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PreferredNameCode.countPreferredNameCodes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PreferredNameCode o", Long.class).getSingleResult();
    }
    
    public static List<PreferredNameCode> PreferredNameCode.findAllPreferredNameCodes() {
        return entityManager().createQuery("SELECT o FROM PreferredNameCode o", PreferredNameCode.class).getResultList();
    }
    
    public static List<PreferredNameCode> PreferredNameCode.findAllPreferredNameCodes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreferredNameCode o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreferredNameCode.class).getResultList();
    }
    
    public static PreferredNameCode PreferredNameCode.findPreferredNameCode(String prefNameCode) {
        if (prefNameCode == null || prefNameCode.length() == 0) return null;
        return entityManager().find(PreferredNameCode.class, prefNameCode);
    }
    
    public static List<PreferredNameCode> PreferredNameCode.findPreferredNameCodeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PreferredNameCode o", PreferredNameCode.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<PreferredNameCode> PreferredNameCode.findPreferredNameCodeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreferredNameCode o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreferredNameCode.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void PreferredNameCode.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PreferredNameCode.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PreferredNameCode attached = PreferredNameCode.findPreferredNameCode(this.prefNameCode);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PreferredNameCode.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PreferredNameCode.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PreferredNameCode PreferredNameCode.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PreferredNameCode merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
