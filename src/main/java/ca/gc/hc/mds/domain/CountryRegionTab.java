package ca.gc.hc.mds.domain;
import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = CountryRegionTabPK.class, schema = "MDSDB", table = "COUNTRY_REGION_TAB", versionField = "", finders =
{ "findCountryRegionTabByRegionDesc", "findCountryRegionTabByCountryCD", "findCountryRegionTabByRegionCD"	})


@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class CountryRegionTab {
	
	@Type(type = "fixedLengthCharType")
	@Column(name = "REGION_DESC", columnDefinition = "char", nullable=false, length=25)
	private String regionDesc;

	public String getRegionDesc() {
		return regionDesc;
	}	
	


}
