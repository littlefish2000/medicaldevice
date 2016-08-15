// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.DeviceSpecies;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DeviceSpecies_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager DeviceSpecies.entityManager;
    
    public static final List<String> DeviceSpecies.fieldNames4OrderClauseFilter = java.util.Arrays.asList("speciesCode", "descEng", "descFR");
    
    public static final EntityManager DeviceSpecies.entityManager() {
        EntityManager em = new DeviceSpecies().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long DeviceSpecies.countDeviceSpecieses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM DeviceSpecies o", Long.class).getSingleResult();
    }
    
    public static List<DeviceSpecies> DeviceSpecies.findAllDeviceSpecieses() {
        return entityManager().createQuery("SELECT o FROM DeviceSpecies o", DeviceSpecies.class).getResultList();
    }
    
    public static List<DeviceSpecies> DeviceSpecies.findAllDeviceSpecieses(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM DeviceSpecies o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, DeviceSpecies.class).getResultList();
    }
    
    public static DeviceSpecies DeviceSpecies.findDeviceSpecies(Long speciesCode) {
        if (speciesCode == null) return null;
        return entityManager().find(DeviceSpecies.class, speciesCode);
    }
    
    public static List<DeviceSpecies> DeviceSpecies.findDeviceSpeciesEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM DeviceSpecies o", DeviceSpecies.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<DeviceSpecies> DeviceSpecies.findDeviceSpeciesEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM DeviceSpecies o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, DeviceSpecies.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void DeviceSpecies.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void DeviceSpecies.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            DeviceSpecies attached = DeviceSpecies.findDeviceSpecies(this.speciesCode);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void DeviceSpecies.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void DeviceSpecies.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public DeviceSpecies DeviceSpecies.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        DeviceSpecies merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}