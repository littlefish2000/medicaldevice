// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Renewal;
import ca.gc.hc.mds.domain.RenewalPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Renewal_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Renewal.entityManager;
    
    public static final List<String> Renewal.fieldNames4OrderClauseFilter = java.util.Arrays.asList("receiptDt");
    
    public static final EntityManager Renewal.entityManager() {
        EntityManager em = new Renewal().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Renewal.countRenewals() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Renewal o", Long.class).getSingleResult();
    }
    
    public static List<Renewal> Renewal.findAllRenewals() {
        return entityManager().createQuery("SELECT o FROM Renewal o", Renewal.class).getResultList();
    }
    
    public static List<Renewal> Renewal.findAllRenewals(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Renewal o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Renewal.class).getResultList();
    }
    
    public static Renewal Renewal.findRenewal(RenewalPK id) {
        if (id == null) return null;
        return entityManager().find(Renewal.class, id);
    }
    
    public static List<Renewal> Renewal.findRenewalEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Renewal o", Renewal.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Renewal> Renewal.findRenewalEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Renewal o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Renewal.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Renewal.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Renewal.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Renewal attached = Renewal.findRenewal(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Renewal.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Renewal.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Renewal Renewal.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Renewal merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
