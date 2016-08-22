package ca.gc.hc.mds.reference;

public enum YesNoType {
 Yes("Y"),
 No("N");
 private String value;
	YesNoType(String value){
		this.value= value;
	}
public String getValue(){
	return value;
}
}
