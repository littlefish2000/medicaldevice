package ca.gc.hc.mds.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ca.gc.hc.mds.domain.Device;
import ca.gc.hc.mds.domain.DeviceSupersede;
import ca.gc.hc.mds.transparent.TranDevice;

public class DeviceService {
	
	public TranDevice populateTranDevice(Long deviceID){
		TranDevice td = new TranDevice();		
		
		Device device = Device.findDevice(deviceID);
				
		DeviceSupersede superSeded = findDeviceSupersedeBySuperSedesID(deviceID);		
		DeviceSupersede superSedes = DeviceSupersede.findDeviceSupersede(deviceID);
		
		if (device != null){
			td.setDeviceId(device.getDeviceId());
			td.setPerfnameCode(device.getPerfnameCode());
			td.setRiskClassification(device.getRiskClassification());		
			td.setTradeName(device.getTradeName());
			td.setUsageCode(device.getUsageCode());			
		}
	
		
		if (superSeded != null){
			td.setSuperSededID(superSeded.getSuperSededID());
		}
		
		if (superSedes != null){
			td.setSuperSedesID(superSedes.getSuperSedesID());
		}		
		
		
		return td;		
	}
	
	
	public void persistDeviceInfo(TranDevice td){
		
		/**
		 * Save info in relevant tables.
		 */
		
		Long id = persistsDevice(td);		
		
		/**
		 * Update device Id, needed for newly created device
		 */
		td.setDeviceId(id);
		
		if (td.getSuperSededID() != null && td.getSuperSededID() > 0){
			persistDeviceSuperSeded(td);
		}
		
		if (td.getSuperSedesID() != null &&  td.getSuperSedesID() > 0  ){
			persistDeviceSuperSedes(td);	
		}
		
	}
	
	
	private Long persistsDevice(TranDevice td){
		Device device =  getPopulatedDevice(td);
		
		EntityManager entityManager = Device.entityManager();
		
		if (device.getDeviceId() != null && device.getDeviceId() > 0 ){
			entityManager.merge(device);
		}else{
			entityManager.persist(device);
		}		
		entityManager.flush();	
		
		/**
		 * TODO:::: To be tested for newly created Device......
		 */
		Long id = device.getDeviceId();
		return id;
	}
	
	/**
	 * 
	 * @param td
	 * @return
	 */
	private Device getPopulatedDevice(TranDevice td){
		Device d = null;
		
		if (td.getDeviceId() != null && td.getDeviceId() > 1){
			d = Device.findDevice(td.getDeviceId());			
		}else {
			d = new Device();
			d.setEntryDate(new Date());
		}
		
		d.setLastChangeDate(new Date());
		
		d.setPerfnameCode(td.getPerfnameCode());
		
		d.setRiskClassification(td.getRiskClassification());
		
		d.setTradeName(td.getTradeName());
		
		d.setUsageCode(td.getUsageCode());		
			
		return d;
	}
	
	
	private void persistDeviceSuperSeded(TranDevice td){
		EntityManager entityManager = DeviceSupersede.entityManager();
		
		Long id = td.getSuperSededID();
		
		DeviceSupersede ds = DeviceSupersede.findDeviceSupersede(id);
		if (ds != null){
			ds.setSuperSedesID(td.getDeviceId());
			entityManager.merge(ds);
			
		}else{
			ds = new DeviceSupersede();
			ds.setSuperSededID(id);
			ds.setSuperSedesID(td.getDeviceId());
			entityManager.persist(ds);			
		}
		
		entityManager.flush();
	}
	
	private void persistDeviceSuperSedes(TranDevice td){
		
		EntityManager entityManager = DeviceSupersede.entityManager();		
		Long id = td.getSuperSedesID();
		
		
		DeviceSupersede ds = DeviceSupersede.findDeviceSupersede(td.getDeviceId());
		if (ds != null){			
			ds.setSuperSedesID(id);			
			entityManager.merge(ds);
			
		}else{
			ds = new DeviceSupersede();
			ds.setSuperSededID(td.getDeviceId());
			ds.setSuperSedesID(id);
			entityManager.persist(ds);			
		}
		
		entityManager.flush();
		
	}
	
	
	
	
	/***
	 * TODO:::::::
	 * @param deviceID
	 * @return
	 */
	private DeviceSupersede findDeviceSupersedeBySuperSedesID(Long superSedesID){
		DeviceSupersede ds = null;
		
		EntityManager entityManager = DeviceSupersede.entityManager();		
		
		String queryStr =  //  "SELECT  ds  "   +    
					"FROM DeviceSupersede AS ds WHERE ds.superSedesID = :superSedesID ";
			
		
		TypedQuery<DeviceSupersede>  query = entityManager.createQuery(queryStr, DeviceSupersede.class);
		
		query.setParameter("superSedesID", superSedesID);
		ds = query.getSingleResult();
		
		return ds;
	}
	
	


}
