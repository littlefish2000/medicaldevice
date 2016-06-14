// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.domain.CompanyHistory;
import ca.gc.hc.mds.web.CompanyHistoryController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CompanyHistoryController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByCompany", "form" }, method = RequestMethod.GET)
    public String CompanyHistoryController.findCompanyHistorysByCompanyForm(Model uiModel) {
        uiModel.addAttribute("companys", Company.findAllCompanys());
        return "companyhistorys/findCompanyHistorysByCompany";
    }
    
    @RequestMapping(params = "find=ByCompany", method = RequestMethod.GET)
    public String CompanyHistoryController.findCompanyHistorysByCompany(@RequestParam("company") Company company, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("companyhistorys", CompanyHistory.findCompanyHistorysByCompany(company, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) CompanyHistory.countFindCompanyHistorysByCompany(company) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("companyhistorys", CompanyHistory.findCompanyHistorysByCompany(company, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "companyhistorys/list";
    }
    
}