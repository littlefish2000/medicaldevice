package ca.gc.hc.mds.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.transparent.TranApplicationLicenceSummary;
import ca.gc.hc.mds.transparent.TranDeviceSummaryStatus;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierType = ApplicationDevicePK.class,table = "APPLICATION_DEVICE")
public class ApplicationDevice {
	
	/**
	 */
	@Type(type = "fixedLengthCharType")
	@Column(name = "APPL_DEVICE_STATUS", columnDefinition = "char", nullable = false, length = 2)
	@Size(min = 0, max = 2)
	private String appldeviceStatus;
	
    /**
     */
    @NotNull
    @Column(name = "STATUS_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date statusDate;
    
    
    /**
     */
    @Type(type = "fixedLengthCharType")
    @Column(name = "EVALUATION_REQUIRED", nullable = false, length=1,columnDefinition = "char(1)")
    private String evaluationRequired = null;
    
    /**
     */   
    @Column(name = "LICENCE_DT", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date licenceDate;
     
    
	public static List<TranApplicationLicenceSummary> findApplicationLicenceSummaryByDeviceId(Long deviceId) {
		if (deviceId == null)
			throw new IllegalArgumentException("The deviceId argument is required");
		EntityManager em = DeviceSummaryStatusVw.entityManager();

		String queryStr = "SELECT NEW ca.gc.hc.mds.transparent.TranApplicationLicenceSummary(ad.id.applicationId,a.applicationType,ad.appldeviceStatus,ad.statusDate,a.licenceName,ad.evaluationRequired,ad.licenceDate) "
				+ "FROM ApplicationDevice AS ad, Application as a  WHERE ad.id.deviceId = :deviceId and a.applicationId = ad.id.applicationId ";

		TypedQuery<TranApplicationLicenceSummary> query = em.createQuery(queryStr, TranApplicationLicenceSummary.class);
		query.setParameter("deviceId", deviceId);
		List<TranApplicationLicenceSummary> results = query.getResultList();
		TranApplicationLicenceSummary.resetId(results);
		return results;
	}
}
