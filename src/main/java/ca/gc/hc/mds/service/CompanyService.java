package ca.gc.hc.mds.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;

import ca.gc.hc.mds.domain.Company;

@Configurable
public class CompanyService {
	
    @PersistenceContext
    transient EntityManager entityManager;

    public static final EntityManager entityManager() {
        EntityManager em = new CompanyService().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
	
    public static long countCompanys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Company o", Long.class).getSingleResult();
    }
    
    public static boolean getMDLStatus(Company company) {
    	Long iMdl = entityManager().createQuery("SELECT COUNT(*) FROM RptLicence as o where o.licenceStatus IN ('I','P','D') and o.companyId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();

    	if (iMdl >0) 
    		return true;
    	else 
    		return false;
    }    
}
