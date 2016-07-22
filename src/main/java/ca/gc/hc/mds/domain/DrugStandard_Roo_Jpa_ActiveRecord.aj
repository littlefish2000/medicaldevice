// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DrugStandard;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DrugStandard_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager DrugStandard.entityManager;
    
    public static final List<String> DrugStandard.fieldNames4OrderClauseFilter = java.util.Arrays.asList("drugstandardCd", "drugstandardDesc");
    
    public static final EntityManager DrugStandard.entityManager() {
        EntityManager em = new DrugStandard().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long DrugStandard.countDrugStandards() {
        return entityManager().createQuery("SELECT COUNT(o) FROM DrugStandard o", Long.class).getSingleResult();
    }
    
    public static List<DrugStandard> DrugStandard.findAllDrugStandards() {
        return entityManager().createQuery("SELECT o FROM DrugStandard o", DrugStandard.class).getResultList();
    }
    
    public static List<DrugStandard> DrugStandard.findAllDrugStandards(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM DrugStandard o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, DrugStandard.class).getResultList();
    }
    
    public static List<DrugStandard> DrugStandard.findDrugStandardEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM DrugStandard o", DrugStandard.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<DrugStandard> DrugStandard.findDrugStandardEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM DrugStandard o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, DrugStandard.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void DrugStandard.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void DrugStandard.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            DrugStandard attached = DrugStandard.findDrugStandard(this.drugstandardCd);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void DrugStandard.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void DrugStandard.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public DrugStandard DrugStandard.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        DrugStandard merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
