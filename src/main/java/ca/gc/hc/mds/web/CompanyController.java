package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Company;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import org.joda.time.format.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import ca.gc.hc.mds.domain.CompanyContact;
import ca.gc.hc.mds.domain.CompanyHistory;
import ca.gc.hc.mds.reference.StatusType;

@RequestMapping("/companys")
@Controller
@RooWebScaffold(path = "companys", formBackingObject = Company.class)
@RooWebFinder
@GvNIXWebJQuery
public class CompanyController {

    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("company_statusdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("company_lastchangedate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    	
	
    void populateEditForm(Model uiModel, Company company) {
        uiModel.addAttribute("company", company);
        addDateTimeFormatPatterns(uiModel);
        
        List<CompanyContact> contactList = new ArrayList<CompanyContact>();
        List<CompanyHistory> historyList = new ArrayList<CompanyHistory>();
        
		    if (company.getCompanyId() !=null) {
		        contactList = CompanyContact.findCompanyContactsByCompany(company).getResultList();
		        historyList = CompanyHistory.findCompanyHistorysByCompany(company).getResultList();
		    }
        uiModel.addAttribute("statustypes", Arrays.asList(StatusType.values()));
        uiModel.addAttribute("companycontacts",contactList);
        uiModel.addAttribute("companyhistorys", historyList);
        
    }	
}
