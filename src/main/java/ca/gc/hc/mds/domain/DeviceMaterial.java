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
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;

import ca.gc.hc.mds.transparent.TranDeviceMaterial;

@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(identifierType = DeviceMaterialPK.class, schema = "MDSDB", table = "DEVICE_MATERIALS", versionField = "", finders =
{"findDeviceMaterialsByDeviceID"})
public class DeviceMaterial {

	
	/**
	 * 
	 */
	@Column(name = "END_DT", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date endDate;
	
	/**
	 * 
	 */
	@NotNull
	@Type(type = "fixedLengthCharType")
	@Column(name = "STATUS_CODE", columnDefinition = "char", nullable = false, length = 1)
	@Size(min = 0, max = 1)
	private String statusCode;

	
	
	/**
	 * 
	 */
	@NotNull
	@Column(name="COMMENTS", columnDefinition = "VARCHAR2", nullable = false, length = 120)
	@Size(min = 0, max = 120)
	private String comments;
	
	
	public static List<TranDeviceMaterial> findDeviceMaterialForApplication(Long applicationID, Long originalLicenceNum){
		
		List<TranDeviceMaterial> results = null;
		
		if ( applicationID == null || originalLicenceNum == null){
			/**
			 * Disabling this validation for now as does not work with create new application page, where application id is not available.
			 */
			//throw new IllegalArgumentException("Missing argument: applicationID and/or originalLicenceNum is required.");
			
		}
		
		EntityManager entityManager = DeviceMaterial.entityManager();		
	
		
		String queryStr = "SELECT  DISTINCT NEW ca.gc.hc.mds.transparent.TranDeviceMaterial " 
				+ "(dm.id.deviceID, d.tradeName , ct.countryDesc, dm.id.startDate, dm.endDate, " 
				+ " dm.statusCode, ds.descEng, dt.descEng, dd.descEng , dm.comments)  "       // TODO:: can we support here DECODE( dm.statusCode, 'A', 'Active', 'I', 'Inactive', 'M','Monitor', 'Unknown')??
		+ "FROM " 
				+ "ApplicationDevice AS ad, DeviceMaterial AS dm, Application AS a, Device AS d, CountryTab AS ct, DeviceSpecies AS ds, DeviceTissues AS dt, DeviceDerivatives AS dd "
		+ "WHERE " 
				+ "(dm.id.deviceID = ad.id.deviceId AND ad.id.deviceId = d.deviceId AND ad.id.applicationId = a.applicationId AND "
				+ "dm.id.countryCode = ct.countryCd AND dm.id.speciesCode = ds.speciesCode AND dm.id.tissuesCode = dt.tissuesCode AND "
				+ "dm.id.derivativesCode = dd.derivativesCode AND a.applicationType IN ('F','Z','A','B','L','V','M') AND "
				+ "a.orginLicenseId <> 0 AND  a.orginLicenseId = :originalLicenceNum)  "
		+ "OR  "
				+ "(dm.id.deviceID = ad.id.deviceId AND ad.id.deviceId = d.deviceId AND dm.id.countryCode = ct.countryCd AND "
				+ "dm.id.speciesCode = ds.speciesCode AND dm.id.tissuesCode = dt.tissuesCode AND dm.id.derivativesCode = dd.derivativesCode AND "
				+ "ad.id.applicationId  =  :applicationID  AND a.applicationType IN ('F','C','T','P','Z','L') AND "
				+ "a.orginLicenseId = 0 AND a.applicationId = ad.id.applicationId ) "  
		+ "ORDER BY dm.id.deviceID  ";
			
      
		
		TypedQuery<TranDeviceMaterial> query = entityManager.createQuery(queryStr, TranDeviceMaterial.class);		
		query.setParameter("applicationID", applicationID);
		query.setParameter("originalLicenceNum", originalLicenceNum);
		
		results = query.getResultList();
		TranDeviceMaterial.resetId(results);
		TranDeviceMaterial.updateDeviceMaterialStatus(results);
		
		return results;		
	}
	




	
	
}

