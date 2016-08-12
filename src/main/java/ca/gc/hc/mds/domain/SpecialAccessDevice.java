package ca.gc.hc.mds.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import ca.gc.hc.mds.transparent.TranSpecialAccessSummary;

@RooJavaBean
@RooToString
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
@RooJpaActiveRecord(identifierType = SpecialAccessDevicePK.class, schema = "MDSDB", table = "SPECIAL_ACCESS_DEVICE", versionField = "", finders =
							{"findSpecialAccessDeviceByDeviceID"})
public class SpecialAccessDevice {
	@Column(name = "QUANTITY", columnDefinition = "NUMBER", nullable = false)
	private Long quantity;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "ALT_DEVICE_NAME", columnDefinition = "char", nullable=false, length=45)
	private String altDeviceName;
	
	
	/**
	 * 	
	 * @param deviceId
	 * @return
	 */
	public static List<TranSpecialAccessSummary> findSpecialAccessSummaryByDeviceId(Long deviceId){
		
		List<TranSpecialAccessSummary> results = null;
		
		if (deviceId == null){
			throw new IllegalArgumentException("DeviceId is required: invalid or null device id provided.");
		}
		
		EntityManager entityManager = SpecialAccessDevice.entityManager();

		
		String queryStr = "SELECT  NEW ca.gc.hc.mds.transparent.TranSpecialAccessSummary" 
								+ " (d.id.specialAccessID, s.requestDate,  s.actionDate,  s.actionTaken, d.id.deviceIdentifier)  "
						+ "FROM  SpecialAccessDevice AS d, SpecialAccess AS s   "
						+ " WHERE d.id.deviceID = :deviceId AND s.specialId = d.id.specialAccessID ORDER BY s.requestDate DESC; ";
		
			
		TypedQuery<TranSpecialAccessSummary> query = entityManager.createQuery(queryStr, TranSpecialAccessSummary.class);
		query.setParameter("deviceId", deviceId);
		
		results = query.getResultList();
		TranSpecialAccessSummary.resetId(results);
		
						
		return results;
	}
	
	//TODO:: decode
	
	//		Code Value:  Action Taken
	// 			Code	Description :
	//						Y	Yes
	//						N	No
	//						P	Pending
	//						W	Withdrawal
	//						null	Unknown	 

}
