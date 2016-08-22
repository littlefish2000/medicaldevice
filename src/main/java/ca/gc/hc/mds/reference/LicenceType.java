package ca.gc.hc.mds.reference;


public enum  LicenceType {
	
	Single_Device ("D"),
	Device_Family("F"),
	Device_Group("G"),
	Test_Kit("K"),
	System("S"),
	Device_Group_Family("Y");
	
	private String value;
	LicenceType(String value){
		this.value= value;
	}
	public String getValue(){
	return value;
}

}
