package ca.gc.hc.mds.transparent;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TranDeviceMaterial {
	private Long id;
	private Long deviceID;
	private String deviceTradeName;
	private String countryDesc;
	private Date startDate;
	private Date endDate;
	private String statusDescEng;	
	private String deviceSpeciesDescEng;
	private String deviceTissueDescEng;
	private String deviceDerivativeDescEng;
	private String comments;
	
	public TranDeviceMaterial(Long deviceID, String deviceTradeName, String countryDesc, Date startDate, Date endDate,
			String statusDescEng, String deviceSpeciesDescEng, String deviceTissueDescEng,
			String deviceDerivativeDescEng, String comments) {
		super();
		this.deviceID = deviceID;
		this.deviceTradeName = deviceTradeName;
		this.countryDesc = countryDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusDescEng = statusDescEng;
		this.deviceSpeciesDescEng = deviceSpeciesDescEng;
		this.deviceTissueDescEng = deviceTissueDescEng;
		this.deviceDerivativeDescEng = deviceDerivativeDescEng;
		this.comments = comments;
	}
	
	public static void resetId(List<TranDeviceMaterial> deviceMaterialList) {
		 long count = 0;
		
		 for (TranDeviceMaterial deviceMaterial:deviceMaterialList) {
			 deviceMaterial.setId(++count);    		
	    	    		
		 }
	    	
	}	
	
	
	public static void updateDeviceMaterialStatus(List<TranDeviceMaterial> deviceMaterialList){
		
		Hashtable<String, String> statusTable = new Hashtable<String, String>();	// DECODE( dm.statusCode, 'A', 'Active', 'I', 'Inactive', 'M','Monitor', 'Unknown')
		statusTable.put("A", "Active");
		statusTable.put("I", "Inactive");
		statusTable.put("M", "Monitor");
		
		
		for (TranDeviceMaterial deviceMaterial: deviceMaterialList){
			
			if (deviceMaterial.statusDescEng == null || deviceMaterial.statusDescEng.trim().equals("")
					||statusTable.get(deviceMaterial.statusDescEng.toUpperCase()) == null 
					||statusTable.get(deviceMaterial.statusDescEng.toUpperCase()).equals("")){
				
				deviceMaterial.statusDescEng = "unknown";
			}else{
				deviceMaterial.statusDescEng = statusTable.get(deviceMaterial.statusDescEng.toUpperCase()) ;
			}
			
		}	
		
		
	}
	

}
