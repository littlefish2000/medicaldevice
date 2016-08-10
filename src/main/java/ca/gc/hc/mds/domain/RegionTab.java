package ca.gc.hc.mds.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(schema = "MDSDB", table = "REGION_TAB", versionField = "", finders = { "findRegionTabByRegionCode",
		"findRegionTabByRegionName" })

@TypeDef(name = "fixedLengthCharType", typeClass = ca.gc.hc.mds.reference.OracleLengthCharType.class)
public class RegionTab {

	@Type(type = "fixedLengthCharType")
	@Column(name = "REGION_CODE", columnDefinition = "char", nullable = false, length = 2)
	private String regionCode;

	@Type(type = "fixedLengthCharType")
	@Column(name = "Region_NAME", columnDefinition = "char", nullable = false, length = 30)
	private String regionName;

	public String getRegionCode() {
		return regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

}
