package ca.gc.hc.mds.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

import ca.gc.hc.mds.domain.Company;

@Configurable
public class CompanyService {
	
    @PersistenceContext
    transient EntityManager entityManager;
    
    @Autowired
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}    

    public static final EntityManager entityManager() {
        EntityManager em = new CompanyService().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
	
    public static long countCompanys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Company o", Long.class).getSingleResult();
    }
    
    public static String getMDLStatus(Company company) {
    	Long iMdl = entityManager().createQuery("SELECT COUNT(*) FROM RptLicence as o where o.licenceStatus IN ('I','P','D') and o.companyId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();

    	if (iMdl >0) 
    		return "Yes";
    	else 
    		return "No";
    }
    
    public static String getRegStatus(Company company) {
    	Long iReg = entityManager().createQuery("SELECT COUNT(*) FROM RptLicence as o where o.licenceStatus IN ('I','P','D') and o.companyAuthId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();

    	if (iReg >0) 
    		return "Yes";
    	else 
    		return "No";
    }       
}