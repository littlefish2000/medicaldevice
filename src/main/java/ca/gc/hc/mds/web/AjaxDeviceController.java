package ca.gc.hc.mds.web;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.gc.hc.mds.domain.DeviceSAP;

@RequestMapping("/ajax/device")
@Controller
@Transactional
public class AjaxDeviceController {
	
	@RequestMapping(value = "/perform_device_sap_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public DeviceSAP performDeviceSAPUpdate(@RequestBody DeviceSAP deviceSAP){
		
		EntityManager entityManager = DeviceSAP.entityManager();
		deviceSAP = entityManager.merge(deviceSAP);
		entityManager.flush();
		
		return deviceSAP;
		
	}
	
	@RequestMapping(value = "/cancel_device_sap_update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public DeviceSAP canceDeviceSAPUpdate(@RequestParam(value = "device_id", required = true) Long deviceId){
		
		DeviceSAP deviceSAP = DeviceSAP.findDeviceSAP(deviceId);
		return deviceSAP;
		
	}
	
	
	
	

}
