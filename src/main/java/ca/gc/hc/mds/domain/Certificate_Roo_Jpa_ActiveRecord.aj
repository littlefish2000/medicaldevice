// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.domain;

import ca.gc.hc.mds.domain.Certificate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Certificate_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Certificate.entityManager;
    
    public static final List<String> Certificate.fieldNames4OrderClauseFilter = java.util.Arrays.asList("origcertificateId", "certificateId", "statusDate", "receiptDate", "entryDate", "licenceStatus", "systemuserId");
    
    public static final EntityManager Certificate.entityManager() {
        EntityManager em = new Certificate().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Certificate.countCertificates() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Certificate o", Long.class).getSingleResult();
    }
    
    public static List<Certificate> Certificate.findAllCertificates() {
        return entityManager().createQuery("SELECT o FROM Certificate o", Certificate.class).getResultList();
    }
    
    public static List<Certificate> Certificate.findAllCertificates(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Certificate o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Certificate.class).getResultList();
    }
    
    public static Certificate Certificate.findCertificate(String origcertificateId) {
        if (origcertificateId == null || origcertificateId.length() == 0) return null;
        return entityManager().find(Certificate.class, origcertificateId);
    }
    
    public static List<Certificate> Certificate.findCertificateEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Certificate o", Certificate.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Certificate> Certificate.findCertificateEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Certificate o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Certificate.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Certificate.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Certificate.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Certificate attached = Certificate.findCertificate(this.origcertificateId);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Certificate.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Certificate.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Certificate Certificate.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Certificate merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
