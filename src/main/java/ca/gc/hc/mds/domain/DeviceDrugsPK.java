package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;


@RooToString
@RooEquals
@RooIdentifier
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class DeviceDrugsPK {
	
	@NotNull
	@Column(name = "DEVICE_ID", columnDefinition = "NUMBER", nullable = false)
	private Long deviceID;
	
	@NotNull
	@Column(name = "DRUG_ID", columnDefinition = "NUMBER", nullable = false)
	private Long drugID;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "BRAND_TRADE_NAME", columnDefinition = "char", nullable = false, length = 150)
	@Size(min = 0, max = 150)
	private String brandTradeName;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "ACTIVE_INGREDIENT", columnDefinition = "char", nullable = false, length = 150)
	@Size(min = 0, max = 150)
	private String activeIngredient;

	
	@Type(type = "fixedLengthCharType")
	@Column(name = "DRUG_MFG_NAME", columnDefinition = "char", nullable = false, length = 90)
	@Size(min = 0, max = 90)
	private String drugMfgName;

}
