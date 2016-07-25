package ca.gc.hc.mds.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@Table(schema = "MDSDB",name = "PREF_NAME_MAST")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "",  schema = "MDSDB", identifierColumn = "PREF_NAME_MAST", 
identifierField = "prefNameCode", identifierType = String.class, table = "PREF_NAME_MAST",finders =
{ "findPreferredNameCodesByPrefNameCode",
		})
public class PreferredNameCode {
	@Id   
    @Column(name = "PREF_NAME_CODE",columnDefinition = "char",nullable=false, length=6)
    private  String prefNameCode;

    /**
     */
    @Column(name = "PREF_DESC_ENG1", columnDefinition = "char",nullable=false, length=60)  
    private String prefDescEng1;

    @Column(name = "PREF_DESC_ENG2", columnDefinition = "char",nullable=false, length=60) 
    private String prefDescEng2;
    
    @Column(name = "PREF_DESC_FR1", columnDefinition = "char",nullable=false, length=60)
    private String prefDescFr1;
    
    @Column(name = "PREF_DESC_FR2", columnDefinition = "char")
    @Size(min = 0, max = 60)
    private String prefDescFr2;    

    @Column(name = "RISK_CLASSIFICATION", columnDefinition = "NUMBER")
    private Integer riskClassification;
    

    @Column(name = "REGULATED_BY", columnDefinition = "char")
    @Size(min = 0, max = 2)
    private String regulatedBy;

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("prefNameCode", "prefDescEng1", "prefDescEng2", "prefDescFr1", "prefDescFr2", "riskClassification", "regulatedBy");

	public static final EntityManager entityManager() {
        EntityManager em = new PreferredNameCode().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPreferredNameCodes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PreferredNameCode o", Long.class).getSingleResult();
    }

	public static List<PreferredNameCode> findAllPreferredNameCodes() {
        return entityManager().createQuery("SELECT o FROM PreferredNameCode o", PreferredNameCode.class).getResultList();
    }

	public static List<PreferredNameCode> findAllPreferredNameCodes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreferredNameCode o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreferredNameCode.class).getResultList();
    }

	public static PreferredNameCode findPreferredNameCode(String prefNameCode) {
		if (prefNameCode == null || prefNameCode.length() == 0) throw new IllegalArgumentException("The prefNameCode argument is required");
        EntityManager em = PreferredNameCode.entityManager();
        return (em.createQuery("SELECT o FROM PreferredNameCode AS o WHERE o.prefNameCode = '" + prefNameCode + "'", PreferredNameCode.class).getSingleResult());
    }

	public static List<PreferredNameCode> findPreferredNameCodeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PreferredNameCode o", PreferredNameCode.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<PreferredNameCode> findPreferredNameCodeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
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
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PreferredNameCode attached = PreferredNameCode.findPreferredNameCode(this.prefNameCode);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public PreferredNameCode merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PreferredNameCode merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindPreferredNameCodesByPrefNameCode(String prefNameCode) {
        if (prefNameCode == null || prefNameCode.length() == 0) throw new IllegalArgumentException("The prefNameCode argument is required");
        EntityManager em = PreferredNameCode.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM PreferredNameCode AS o WHERE o.prefNameCode = :prefNameCode", Long.class);
        q.setParameter("prefNameCode", prefNameCode);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<PreferredNameCode> findPreferredNameCodesByPrefNameCode(String prefNameCode) {
        if (prefNameCode == null || prefNameCode.length() == 0) throw new IllegalArgumentException("The prefNameCode argument is required");
        EntityManager em = PreferredNameCode.entityManager();
        TypedQuery<PreferredNameCode> q = em.createQuery("SELECT o FROM PreferredNameCode AS o WHERE o.prefNameCode = :prefNameCode", PreferredNameCode.class);
        q.setParameter("prefNameCode", prefNameCode);
        return q;
    }

	public static TypedQuery<PreferredNameCode> findPreferredNameCodesByPrefNameCode(String prefNameCode, String sortFieldName, String sortOrder) {
        if (prefNameCode == null || prefNameCode.length() == 0) throw new IllegalArgumentException("The prefNameCode argument is required");
        EntityManager em = PreferredNameCode.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM PreferredNameCode AS o WHERE o.prefNameCode = :prefNameCode");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<PreferredNameCode> q = em.createQuery(queryBuilder.toString(), PreferredNameCode.class);
        q.setParameter("prefNameCode", prefNameCode);
        return q;
    }

	public String getPrefNameCode() {
        return this.prefNameCode;
    }

	public void setPrefNameCode(String prefNameCode) {
        this.prefNameCode = prefNameCode;
    }

	public String getPrefDescEng1() {
        return this.prefDescEng1;
    }

	public void setPrefDescEng1(String prefDescEng1) {
        this.prefDescEng1 = prefDescEng1;
    }

	public String getPrefDescEng2() {
        return this.prefDescEng2;
    }

	public void setPrefDescEng2(String prefDescEng2) {
        this.prefDescEng2 = prefDescEng2;
    }

	public String getPrefDescFr1() {
        return this.prefDescFr1;
    }

	public void setPrefDescFr1(String prefDescFr1) {
        this.prefDescFr1 = prefDescFr1;
    }

	public String getPrefDescFr2() {
        return this.prefDescFr2;
    }

	public void setPrefDescFr2(String prefDescFr2) {
        this.prefDescFr2 = prefDescFr2;
    }

	public Integer getRiskClassification() {
        return this.riskClassification;
    }

	public void setRiskClassification(Integer riskClassification) {
        this.riskClassification = riskClassification;
    }

	public String getRegulatedBy() {
        return this.regulatedBy;
    }

	public void setRegulatedBy(String regulatedBy) {
        this.regulatedBy = regulatedBy;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
