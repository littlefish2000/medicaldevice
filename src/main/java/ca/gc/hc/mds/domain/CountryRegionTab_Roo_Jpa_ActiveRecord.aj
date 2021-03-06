// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.CountryRegionTab;
import ca.gc.hc.mds.domain.CountryRegionTabPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CountryRegionTab_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CountryRegionTab.entityManager;
    
    public static final List<String> CountryRegionTab.fieldNames4OrderClauseFilter = java.util.Arrays.asList("regionDesc");
    
    public static final EntityManager CountryRegionTab.entityManager() {
        EntityManager em = new CountryRegionTab().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CountryRegionTab.countCountryRegionTabs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CountryRegionTab o", Long.class).getSingleResult();
    }
    
    public static List<CountryRegionTab> CountryRegionTab.findAllCountryRegionTabs() {
        return entityManager().createQuery("SELECT o FROM CountryRegionTab o", CountryRegionTab.class).getResultList();
    }
    
    public static List<CountryRegionTab> CountryRegionTab.findAllCountryRegionTabs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CountryRegionTab o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CountryRegionTab.class).getResultList();
    }
    
    public static CountryRegionTab CountryRegionTab.findCountryRegionTab(CountryRegionTabPK id) {
        if (id == null) return null;
        return entityManager().find(CountryRegionTab.class, id);
    }
    
    public static List<CountryRegionTab> CountryRegionTab.findCountryRegionTabEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CountryRegionTab o", CountryRegionTab.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CountryRegionTab> CountryRegionTab.findCountryRegionTabEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CountryRegionTab o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CountryRegionTab.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CountryRegionTab.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CountryRegionTab.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CountryRegionTab attached = CountryRegionTab.findCountryRegionTab(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CountryRegionTab.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CountryRegionTab.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CountryRegionTab CountryRegionTab.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CountryRegionTab merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
