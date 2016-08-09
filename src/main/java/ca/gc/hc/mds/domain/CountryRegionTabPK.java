package ca.gc.hc.mds.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.SerializableType;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public final class CountryRegionTabPK // extends SerializableType
{
   /*
	public CountryRegionTabPK(Class serializableClass) {
		super(serializableClass);
		// TODO Auto-generated constructor stub
	}
   */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "COUNTRY_CD", columnDefinition = "char", nullable=false, length=2)
	private String countryCD;
	
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "REGION_CD", columnDefinition = "char", nullable=false, length=3)
	private String regionCD;


	public String getCountryCD() {
		return countryCD;
	}

	public String getRegionCD() {
		return regionCD;
	}
	
	

}
