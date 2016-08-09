package ca.gc.hc.mds.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.transparent.TranDeviceSummaryStatus;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB", table = "DEVICE_SUMMARY_STATUS_VW", finders = {
		"findDeviceSummaryStatusVwsByDeviceId" })
public class DeviceSummaryStatusVw {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEVICE_ID")
	private Long deviceId;

	@Column(name = "ORIGINAL_LICENCE_NO", columnDefinition = "NUMBER")
	private Long originalicenceNo;

	/**
	 */
	@Column(name = "LICENCE_STATUS", columnDefinition = "char", nullable = false, length = 1)
	@Type(type = "fixedLengthCharType")
	@Size(min = 0, max = 1)
	private String licenceStatus;

	/**
	 * web mvc scaffold --class ~.web.DeviceIndentContentController
	 * --backingType ~.domain.DeviceIndentContent --path
	 * maintenance/codetable/deviceindentcontent
	 */
	@NotNull
	@Column(name = "LICENCE_STATUS_DT", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date licencestatusDate;

	/**
	 */
	@Column(name = "APPL_DEV_STATUS", columnDefinition = "char", nullable = true, length = 2)
	@Size(min = 0, max = 2)
	private String appldevStatus;

	/**
	 */
	@NotNull
	@Column(name = "APPL_DEV_STATUS_DT", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date applstatusDate;

	public static TypedQuery<Object[]> findDeviceSummaryStatusByDeviceId(Long deviceId) {
		if (deviceId == null)
			throw new IllegalArgumentException("The deviceId argument is required");
		EntityManager em = DeviceSummaryStatusVw.entityManager();
		TypedQuery<Object[]> q = em.createQuery(
				"SELECT o,l FROM DeviceSummaryStatusVw AS o, LicenseStatus as l WHERE o.deviceId = :deviceId and o.licenceStatus=l.licencestatusCd ",
				Object[].class);
		q.setParameter("deviceId", deviceId);
		return q;
	}

	public static List<TranDeviceSummaryStatus> findDeviceSummaryStatusesByDeviceId(Long deviceId) {
		if (deviceId == null)
			throw new IllegalArgumentException("The deviceId argument is required");
		EntityManager em = DeviceSummaryStatusVw.entityManager();

		String queryStr = "SELECT NEW ca.gc.hc.mds.transparent.TranDeviceSummaryStatus(o.originalicenceNo, o.appldevStatus, o.licencestatusDate, l.descr) "
				+ "FROM DeviceSummaryStatusVw AS o, LicenseStatus as l  WHERE o.deviceId = :deviceId and o.licenceStatus=l.licencestatusCd ";

		TypedQuery<TranDeviceSummaryStatus> query = em.createQuery(queryStr, TranDeviceSummaryStatus.class);
		query.setParameter("deviceId", deviceId);
		List<TranDeviceSummaryStatus> results = query.getResultList();
		TranDeviceSummaryStatus.resetId(results);
		return results;
	}
}
