package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.RenAuthCompany;
import ca.gc.hc.mds.domain.RenAuthCompanyPK;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@Controller
public class RenewalController {
	private ConversionService conversionService;

	@Autowired
    public RenewalController(ConversionService conversionService) {
        super();
        this.conversionService = conversionService;
    }
	

    @RequestMapping(method = RequestMethod.POST, value = "/renewal/{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

   
	@RequestMapping(value = "/renewal/licence", params = { "find=ByLicenceId", "form" }, method = RequestMethod.GET)
    public String findLicenceRenewsByLicenceIdForm(Model uiModel) {
        return "renewal/findlicencerenewbylicence";
    }
	
	@RequestMapping(value = "/renewal/licence", params = { "find=ByRegulatoryId", "form" }, method = RequestMethod.GET)
    public String findLicenceRenewsByRegulatoryIdForm(Model uiModel) {
		uiModel.addAttribute("authorizeId","");
		uiModel.addAttribute("companyname","");
		return "renewal/renewauthorcompanylist";
    }
	
	@RequestMapping(value = "/renewal/licence",params = "find=ByRegulatoryId", method = RequestMethod.GET)
    public String findLicenceRenewsByRegulatory(@RequestParam("authorizeId") Long authorizeId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        
		uiModel.addAttribute("authorizeId",authorizeId);
		uiModel.addAttribute("companyname","Arthocarte Corporation");
		if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("renauthcompanys", RenAuthCompany.findRenAuthCompanyEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) RenAuthCompany.countRenAuthCompanys() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("renauthcompanys", RenAuthCompany.findAllRenAuthCompanys(sortFieldName, sortOrder));
        }
		return "renewal/renewauthorcompanylist";
    }

	@RequestMapping(value = "/renauthcompanys/{deviceId}", produces = "text/html")
    public String show(@PathVariable("deviceId") String deviceId, Model uiModel) {
		
        addDateTimeFormatPatterns(uiModel);
//        uiModel.addAttribute("device", RenAuthCompany.findRenAuthCompany(deviceId));
//        uiModel.addAttribute("itemId", deviceId);
        return "renewal/renewcompanyupdate";
    }	
	
	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("device_entrydate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("device_lastchangedate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }	
    
	void populateEditForm(Model uiModel, RenAuthCompany renAuthCompany) {
        uiModel.addAttribute("renAuthCompany", renAuthCompany);
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }    
}
