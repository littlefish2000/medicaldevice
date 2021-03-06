// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Company;
import ca.gc.hc.mds.web.CompanyController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CompanyController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByCompanyId", "form" }, method = RequestMethod.GET)
    public String CompanyController.findCompanysByCompanyIdForm(Model uiModel) {
        return "companys/findCompanysByCompanyId";
    }
    
    @RequestMapping(params = "find=ByCompanyId", method = RequestMethod.GET)
    public String CompanyController.findCompanysByCompanyId(@RequestParam("companyId") Long companyId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("companys", Company.findCompanysByCompanyId(companyId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Company.countFindCompanysByCompanyId(companyId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("companys", Company.findCompanysByCompanyId(companyId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "companys/list";
    }
    
    @RequestMapping(params = { "find=ByCompanyNameLike", "form" }, method = RequestMethod.GET)
    public String CompanyController.findCompanysByCompanyNameLikeForm(Model uiModel) {
        return "companys/findCompanysByCompanyNameLike";
    }
    
    @RequestMapping(params = "find=ByCompanyNameLike", method = RequestMethod.GET)
    public String CompanyController.findCompanysByCompanyNameLike(@RequestParam("companyName") String companyName, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("companys", Company.findCompanysByCompanyNameLike(companyName, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Company.countFindCompanysByCompanyNameLike(companyName) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("companys", Company.findCompanysByCompanyNameLike(companyName, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "companys/list";
    }
    
}
