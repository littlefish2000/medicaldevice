package ca.gc.hc.mds.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", schema = "MDSDB",identifierColumn = "PREF_NAME_WORD", identifierField = "prefNameWord", table = "PREF_DESC_TAB", finders = { "findPreferredNameKeywordsByPrefNameWord" })
public class PreferredNameKeyword {

	@Id    
    @Column(name = "PREF_NAME_WORD", columnDefinition = "char")
	@Size(min = 0, max = 28)
	private String prefNameWord;
}
