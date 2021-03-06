package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.CountryTab;
import ca.gc.hc.mds.domain.DeviceIndentContent;
import ca.gc.hc.mds.domain.Division;
import ca.gc.hc.mds.domain.DrugStandard;
import ca.gc.hc.mds.domain.LicenseStatus;
import ca.gc.hc.mds.domain.RenAuthCompany;
import ca.gc.hc.mds.domain.RenAuthCompanyPK;
import ca.gc.hc.mds.domain.RenLicenceInfo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@Controller
public class CodeTableController {
	private ConversionService conversionService;

	@Autowired
    public CodeTableController(ConversionService conversionService) {
        super();
        this.conversionService = conversionService;
    }
	
   
	@RequestMapping(value = "/maintenancece/tablemaintenance", params = { "codetable" }, method = RequestMethod.GET)
    public String codeTableSelectCreate(Model uiModel) {
		uiModel.addAttribute("licenceId","");
        return "maintenance/tablemaintenance/codetablesearch";
    }
	
	@RequestMapping(value = "/maintenancece/tablemaintenance",params = "act=codetable", method = RequestMethod.GET)
    public String codeTableSelectForm(@RequestParam(value = "tablename") String tableName, Model uiModel) {
		if (tableName.equalsIgnoreCase("DRUG_STANDARD"))
			return DrugStandardList(uiModel);
		else if (tableName.equalsIgnoreCase("COUNTRY_TAB"))
			return CountryTabList(uiModel);
		else if (tableName.equalsIgnoreCase("LICENCE_STATUS"))
			return LicenceStatusList(uiModel);
		else if (tableName.equalsIgnoreCase("DIVISION"))
			return DivisionList(uiModel);	
		else if (tableName.equalsIgnoreCase("DEVICE_IDENT_CONTENT"))
			return DiviceIndentCodeList(uiModel);			
		else
			return "maintenance/tablemaintenance/codetablesearch";
    }

	public String DiviceIndentCodeList(Model uiModel) {
		Integer page=1;
		Integer size=10;
		String sortFieldName = null;
		String sortOrder = null;
		
        uiModel.asMap().clear();
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("deviceindentcontents", DeviceIndentContent.findDeviceIndentContentEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) DeviceIndentContent.countDeviceIndentContents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("deviceindentcontents", DeviceIndentContent.findAllDeviceIndentContents(sortFieldName, sortOrder));
        }
        return "redirect:/maintenance/codetable//deviceindentcontent";
	}	
	
	public String DivisionList(Model uiModel) {
		Integer page=1;
		Integer size=10;
		String sortFieldName = null;
		String sortOrder = null;
		
        uiModel.asMap().clear();
        uiModel.addAttribute("divisions",Division.findAllDivisions(sortFieldName, sortOrder));
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable//division";
	}		
	
	public String LicenceStatusList(Model uiModel) {
		Integer page=1;
		Integer size=10;
		String sortFieldName = null;
		String sortOrder = null;
		
        uiModel.asMap().clear();
        uiModel.addAttribute("licensestatuses", LicenseStatus.findAllLicenseStatuses(sortFieldName, sortOrder));
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/licenseStatus";
	}	
	
	public String CountryTabList(Model uiModel) {
		Integer page=1;
		Integer size=10;
		String sortFieldName = null;
		String sortOrder = null;
		
        uiModel.asMap().clear();
        uiModel.addAttribute("countrytabs", CountryTab.findAllCountryTabs(sortFieldName, sortOrder));
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/countrytab";
	}	
	
	public String DrugStandardList(Model uiModel) {
		Integer page=1;
		Integer size=10;
		String sortFieldName = null;
		String sortOrder = null;
		
        uiModel.asMap().clear();
        uiModel.addAttribute("drugstandards", DrugStandard.findAllDrugStandards(sortFieldName, sortOrder));
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/drugstandard";
	}
	
}
