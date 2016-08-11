package ca.gc.hc.mds.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.transparent.TranCompanyApplicationSummary;
import ca.gc.hc.mds.transparent.TranDeviceSummaryStatus;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",table = "DEVICE_COMPANY_VW")
public class DeviceCompanyVw {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEVICE_ID",columnDefinition = "NUMBER")
	private Long deviceId;

	/**
	 */
	@Column(name = "APPL_DEVICE_STATUS", columnDefinition = "char", nullable = true, length = 2)
	@Size(min = 0, max = 2)
	private String appldeviceStatus;
	
	@Column(name = "ORIGINAL_LICENCE_NO", columnDefinition = "NUMBER")
	private Long originalLicenceNo;	
	
	@Column(name = "MFG_COMPANY_ID", columnDefinition = "NUMBER")
	private Long mfgCompanyId;	
	
	@Column(name = "AUTH_COMPANY_ID", columnDefinition = "NUMBER")
	private Long authCompanyId;		
	
	
	public static List<TranCompanyApplicationSummary> findCompanyApplictionSummaryByDeviceId(Long deviceId) {
		if (deviceId == null)
			throw new IllegalArgumentException("The deviceId argument is required");
		EntityManager em = DeviceSummaryStatusVw.entityManager();

		String queryStr = "SELECT distinct NEW ca.gc.hc.mds.transparent.TranCompanyApplicationSummary(dc.originalLicenceNo, dc.mfgCompanyId, c1.companyName,dc.authCompanyId,c2.companyName,dss.licenceStatus) "
				+ "FROM DeviceCompanyVw AS dc, Company as c1, Company as c2, DeviceSummaryStatusVw as dss  WHERE c1.companyId=dc.mfgCompanyId and c2.companyId = dc.authCompanyId  and dc.deviceId = :deviceId and dc.deviceId=dss.deviceId and dc.originalLicenceNo = dss.originalicenceNo ";

		TypedQuery<TranCompanyApplicationSummary> query = em.createQuery(queryStr, TranCompanyApplicationSummary.class);
		query.setParameter("deviceId", deviceId);
		List<TranCompanyApplicationSummary> results = query.getResultList();
		TranCompanyApplicationSummary.resetId(results);
		return results;
	}	
}
