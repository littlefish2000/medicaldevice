// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.web.ApplicationController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect ApplicationController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByApplcationNameLike", "form" }, method = RequestMethod.GET)
    public String ApplicationController.findApplicationsByApplcationNameLikeForm(Model uiModel) {
        return "applications/findApplicationsByApplcationNameLike";
    }
    
    @RequestMapping(params = "find=ByApplcationNameLike", method = RequestMethod.GET)
    public String ApplicationController.findApplicationsByApplcationNameLike(@RequestParam("applcationName") String applcationName, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("applications", Application.findApplicationsByApplcationNameLike(applcationName, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Application.countFindApplicationsByApplcationNameLike(applcationName) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("applications", Application.findApplicationsByApplcationNameLike(applcationName, sortFieldName, sortOrder).getResultList());
        }
        return "applications/list";
    }
    
    @RequestMapping(params = { "find=ById", "form" }, method = RequestMethod.GET)
    public String ApplicationController.findApplicationsByIdForm(Model uiModel) {
        return "applications/findApplicationsById";
    }
    
    @RequestMapping(params = "find=ById", method = RequestMethod.GET)
    public String ApplicationController.findApplicationsById(@RequestParam("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("applications", Application.findApplicationsById(id, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Application.countFindApplicationsById(id) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("applications", Application.findApplicationsById(id, sortFieldName, sortOrder).getResultList());
        }
        return "applications/list";
    }
    
}
