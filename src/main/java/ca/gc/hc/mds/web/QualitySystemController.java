package ca.gc.hc.mds.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.hc.mds.domain.RenAuthCompany;


@Controller
public class QualitySystemController {

	private ConversionService conversionService;
	
	@Autowired
    public QualitySystemController(ConversionService conversionService) {
        super();
        this.conversionService = conversionService;
    }
		
//    @RequestMapping(method = RequestMethod.POST, value = "{id}")
//    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    @RequestMapping
//    public String index() {
//        return "qualitysystem/index";
//    }
    
	@RequestMapping(value = "/qualitysystem/cert/new", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
		 //opulateEditForm(uiModel, new Device());
         return "qualitysystem/cert/new";
    }    
	

	
}
