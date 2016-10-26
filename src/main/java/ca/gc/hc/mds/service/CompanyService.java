package ca.gc.hc.mds.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.CompanyContact;
import ca.gc.hc.mds.transparent.TranCompanyFinance;

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
    
    
    public static String getMdelStatus(Company company) {
    	Long iReg = entityManager().createQuery("SELECT COUNT(*) FROM Establishment as o where o.licenceStatus IN ('I','P') and o.companyId = :companyid or o.companyMailId = :companyid  or o.comapnyAddId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();
    	
    	System.out.println("medl="+iReg);
    	
    	if (iReg >0) 
    		return "Yes";
    	else 
    		return "No";
    }     
    
    public static String getMfgStatus(Company company) {
    	Long iReg = entityManager().createQuery("SELECT COUNT(*) FROM Manufacturers as m, Establishment as e where e.establishmentId = m.id.establishmentId and e.licenceStatus IN ('I','P') and m.status = 'A' and m.id.mfgId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();

    	
    	if (iReg >0) 
    		return "Yes";
    	else 
    		return "No";
    }  
    
    public static String getSiteStatus(Company company) {
    	Long iReg = entityManager().createQuery("SELECT COUNT(*) FROM Sites as s, Establishment as e where e.establishmentId = s.id.establishmentId and s.status = 'A' and s.id.siteId = :companyid", Long.class)
    			.setParameter("companyid", company.getCompanyId()).getSingleResult();
    	
    	System.out.println("Sites="+iReg);
    	
    	if (iReg >0) 
    		return "Yes";
    	else 
    		return "No";
    }  
    
    
    public static TranCompanyFinance getFianaceInfo(Company company) {
    	if (company.getCompanyId() == null)
			throw new IllegalArgumentException("The company id is required");
		
		String queryStr = "SELECT NEW ca.gc.hc.mds.transparent.TranCompanyFinance(c1.companyId,c1.billToId,c2.companyName,cc.contactName,cc.e_MAIL) "
				+ "FROM Company as c1, Company as c2 ,CompanyContact as cc  WHERE c1.companyId = :companyId and c2.companyId = c1.billToId and cc.companyContactId = c1.contactId";

		TranCompanyFinance result = entityManager().createQuery(queryStr, TranCompanyFinance.class)
				.setParameter("companyId", company.getCompanyId()).getSingleResult();

		return result;
    }
    
    public static List<CompanyContact> findCompanyContactsByCompanyId(Long companyId) {
        if (companyId == null) throw new IllegalArgumentException("The company id argument is required");
        Company company = new Company();
        company.setCompanyId(companyId);
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM CompanyContact AS o WHERE o.company = :company");

        TypedQuery<CompanyContact> q = entityManager().createQuery(queryBuilder.toString(), CompanyContact.class);
        q.setParameter("company", company);
        return q.getResultList();    	
    }
}
