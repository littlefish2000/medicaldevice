package ca.gc.hc.mds.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

@Entity
@Table(schema = "MDSDB",name = "PREF_DESC_TAB")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "PREF_NAME_WORD", identifierField = "prefNameWord", table = "PREF_DESC_TAB", finders = { "findPreferredNameKeywordsByPrefNameWord" })
public class PreferredNameKeyword {

	@Id    
    @Column(name = "PREF_NAME_WORD", columnDefinition = "char(28)",nullable=false)
	private String prefNameWord;

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("prefNameWord");

	public static final EntityManager entityManager() {
        EntityManager em = new PreferredNameKeyword().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPreferredNameKeywords() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PreferredNameKeyword o", Long.class).getSingleResult();
    }

	public static List<PreferredNameKeyword> findAllPreferredNameKeywords() {
        return entityManager().createQuery("SELECT o FROM PreferredNameKeyword o", PreferredNameKeyword.class).getResultList();
    }

	public static List<PreferredNameKeyword> findAllPreferredNameKeywords(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreferredNameKeyword o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreferredNameKeyword.class).getResultList();
    }

	/*public static PreferredNameKeyword findPreferredNameKeyword(String prefNameWord) {
        if (prefNameWord == null || prefNameWord.length() == 0) return null;
        return entityManager().find(PreferredNameKeyword.class, prefNameWord);
    }*/
	public static PreferredNameKeyword findPreferredNameKeyword(String prefNameWord) {
        if (prefNameWord == null || prefNameWord.length() == 0) return null;
        
//        return entityManager().createQuery("SELECT o FROM PreferredNameKeyword o where prefNameWord = :prefNameWord ", PreferredNameKeyword.class).setParameter("prefNameWord", prefNameWord).getFirstResult();
        /*Query q=  entityManager().createQuery("SELECT o FROM PreferredNameKeyword o where o.prefNameWord='"+ prefNameWord +"'",PreferredNameKeyword.class);
        List<PreferredNameKeyword> pList = q.getResultList();
        
        PreferredNameKeyword p = null;
        if (q.getResultList().size() == 1){
         p= pList.get(0);
        }*/
        	
        return (entityManager().createQuery("SELECT o FROM PreferredNameKeyword o where o.prefNameWord='"+ prefNameWord +"'",PreferredNameKeyword.class).getSingleResult());
       
    }
	public static List<PreferredNameKeyword> findPreferredNameKeywordEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PreferredNameKeyword o", PreferredNameKeyword.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<PreferredNameKeyword> findPreferredNameKeywordEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PreferredNameKeyword o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PreferredNameKeyword.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            PreferredNameKeyword attached = PreferredNameKeyword.findPreferredNameKeyword(this.prefNameWord);
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
    public PreferredNameKeyword merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PreferredNameKeyword merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindPreferredNameKeywordsByPrefNameWord(String prefNameWord) {
        if (prefNameWord == null || prefNameWord.length() == 0) throw new IllegalArgumentException("The prefNameWord argument is required");
        EntityManager em = PreferredNameKeyword.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM PreferredNameKeyword AS o WHERE o.prefNameWord = :prefNameWord", Long.class);
        q.setParameter("prefNameWord", prefNameWord);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<PreferredNameKeyword> findPreferredNameKeywordsByPrefNameWord(String prefNameWord) {
        if (prefNameWord == null || prefNameWord.length() == 0) throw new IllegalArgumentException("The prefNameWord argument is required");
        EntityManager em = PreferredNameKeyword.entityManager();
        TypedQuery<PreferredNameKeyword> q = em.createQuery("SELECT o FROM PreferredNameKeyword AS o WHERE o.prefNameWord = :prefNameWord", PreferredNameKeyword.class);
        q.setParameter("prefNameWord", prefNameWord);
        return q;
    }

	public static TypedQuery<PreferredNameKeyword> findPreferredNameKeywordsByPrefNameWord(String prefNameWord, String sortFieldName, String sortOrder) {
        if (prefNameWord == null || prefNameWord.length() == 0) throw new IllegalArgumentException("The prefNameWord argument is required");
        EntityManager em = PreferredNameKeyword.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM PreferredNameKeyword AS o WHERE o.prefNameWord = :prefNameWord");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<PreferredNameKeyword> q = em.createQuery(queryBuilder.toString(), PreferredNameKeyword.class);
        q.setParameter("prefNameWord", prefNameWord);
        return q;
    }

	public String getPrefNameWord() {
        return this.prefNameWord;
    }

	public void setPrefNameWord(String prefNameWord) {
        this.prefNameWord = prefNameWord;
    }
}
