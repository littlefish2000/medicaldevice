// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Registrar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Registrar_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Registrar.entityManager;
    
    public static final List<String> Registrar.fieldNames4OrderClauseFilter = java.util.Arrays.asList("registrarCd", "registrarName", "addrLine1", "addrLine2", "addrline3", "postalCode", "city", "countryCd", "regionCd", "status", "statusDt", "registrarWeb", "validationFax", "validationPhone", "validationEmail", "validationContact", "validationPosition", "cmdcasFax", "cmdcasPhone", "cmdcasEmail", "cmdcasContact", "cmdcasPosition");
    
    public static final EntityManager Registrar.entityManager() {
        EntityManager em = new Registrar().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Registrar.countRegistrars() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Registrar o", Long.class).getSingleResult();
    }
    
    public static List<Registrar> Registrar.findAllRegistrars() {
        return entityManager().createQuery("SELECT o FROM Registrar o", Registrar.class).getResultList();
    }
    
    public static List<Registrar> Registrar.findAllRegistrars(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Registrar o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Registrar.class).getResultList();
    }
    
    public static Registrar Registrar.findRegistrar(String registrarCd) {
        if (registrarCd == null || registrarCd.length() == 0) return null;
        return entityManager().find(Registrar.class, registrarCd);
    }
    
    public static List<Registrar> Registrar.findRegistrarEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Registrar o", Registrar.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Registrar> Registrar.findRegistrarEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Registrar o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Registrar.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Registrar.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Registrar.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Registrar attached = Registrar.findRegistrar(this.registrarCd);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Registrar.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Registrar.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Registrar Registrar.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Registrar merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
