package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Application;
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
    public String codeTableSelectForm( Model uiModel) {
		return "maintenance/tablemaintenance/codetableeng";
    }	
	
}
