// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.SpecialAccessDevice;
import ca.gc.hc.mds.domain.SpecialAccessDevicePK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SpecialAccessDevice_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SpecialAccessDevice.entityManager;
    
    public static final List<String> SpecialAccessDevice.fieldNames4OrderClauseFilter = java.util.Arrays.asList("quantity", "altDeviceName");
    
    public static final EntityManager SpecialAccessDevice.entityManager() {
        EntityManager em = new SpecialAccessDevice().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SpecialAccessDevice.countSpecialAccessDevices() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SpecialAccessDevice o", Long.class).getSingleResult();
    }
    
    public static List<SpecialAccessDevice> SpecialAccessDevice.findAllSpecialAccessDevices() {
        return entityManager().createQuery("SELECT o FROM SpecialAccessDevice o", SpecialAccessDevice.class).getResultList();
    }
    
    public static List<SpecialAccessDevice> SpecialAccessDevice.findAllSpecialAccessDevices(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SpecialAccessDevice o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SpecialAccessDevice.class).getResultList();
    }
    
    public static SpecialAccessDevice SpecialAccessDevice.findSpecialAccessDevice(SpecialAccessDevicePK id) {
        if (id == null) return null;
        return entityManager().find(SpecialAccessDevice.class, id);
    }
    
    public static List<SpecialAccessDevice> SpecialAccessDevice.findSpecialAccessDeviceEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SpecialAccessDevice o", SpecialAccessDevice.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<SpecialAccessDevice> SpecialAccessDevice.findSpecialAccessDeviceEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SpecialAccessDevice o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SpecialAccessDevice.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SpecialAccessDevice.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SpecialAccessDevice.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SpecialAccessDevice attached = SpecialAccessDevice.findSpecialAccessDevice(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SpecialAccessDevice.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SpecialAccessDevice.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SpecialAccessDevice SpecialAccessDevice.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SpecialAccessDevice merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
