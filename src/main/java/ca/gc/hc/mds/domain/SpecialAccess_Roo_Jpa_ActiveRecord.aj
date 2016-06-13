// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.SpecialAccess;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SpecialAccess_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SpecialAccess.entityManager;
    
    public static final List<String> SpecialAccess.fieldNames4OrderClauseFilter = java.util.Arrays.asList("specialId", "physicianId", "facilityId", "requestDate", "actionDate");
    
    public static final EntityManager SpecialAccess.entityManager() {
        EntityManager em = new SpecialAccess().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SpecialAccess.countSpecialAccesses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SpecialAccess o", Long.class).getSingleResult();
    }
    
    public static List<SpecialAccess> SpecialAccess.findAllSpecialAccesses() {
        return entityManager().createQuery("SELECT o FROM SpecialAccess o", SpecialAccess.class).getResultList();
    }
    
    public static List<SpecialAccess> SpecialAccess.findAllSpecialAccesses(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SpecialAccess o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SpecialAccess.class).getResultList();
    }
    
    public static SpecialAccess SpecialAccess.findSpecialAccess(Long specialId) {
        if (specialId == null) return null;
        return entityManager().find(SpecialAccess.class, specialId);
    }
    
    public static List<SpecialAccess> SpecialAccess.findSpecialAccessEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SpecialAccess o", SpecialAccess.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<SpecialAccess> SpecialAccess.findSpecialAccessEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SpecialAccess o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SpecialAccess.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SpecialAccess.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SpecialAccess.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SpecialAccess attached = SpecialAccess.findSpecialAccess(this.specialId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SpecialAccess.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SpecialAccess.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SpecialAccess SpecialAccess.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SpecialAccess merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
