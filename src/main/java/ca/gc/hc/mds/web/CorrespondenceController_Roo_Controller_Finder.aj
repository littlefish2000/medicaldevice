// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Correspondence;
import ca.gc.hc.mds.web.CorrespondenceController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CorrespondenceController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByApplicationId", "form" }, method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByApplicationIdForm(Model uiModel) {
        return "correspondences/findCorrespondencesByApplicationId";
    }
    
    @RequestMapping(params = "find=ByApplicationId", method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByApplicationId(@RequestParam("applicationId") Long applicationId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByApplicationId(applicationId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Correspondence.countFindCorrespondencesByApplicationId(applicationId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByApplicationId(applicationId, sortFieldName, sortOrder).getResultList());
        }
        return "correspondences/list";
    }
    
    @RequestMapping(params = { "find=ByCertificateIdEquals", "form" }, method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByCertificateIdEqualsForm(Model uiModel) {
        return "correspondences/findCorrespondencesByCertificateIdEquals";
    }
    
    @RequestMapping(params = "find=ByCertificateIdEquals", method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByCertificateIdEquals(@RequestParam("certificateId") String certificateId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByCertificateIdEquals(certificateId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Correspondence.countFindCorrespondencesByCertificateIdEquals(certificateId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByCertificateIdEquals(certificateId, sortFieldName, sortOrder).getResultList());
        }
        return "correspondences/list";
    }
    
    @RequestMapping(params = { "find=ByCompanyIdEquals", "form" }, method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByCompanyIdEqualsForm(Model uiModel) {
        return "correspondences/findCorrespondencesByCompanyIdEquals";
    }
    
    @RequestMapping(params = "find=ByCompanyIdEquals", method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByCompanyIdEquals(@RequestParam("companyId") Long companyId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByCompanyIdEquals(companyId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Correspondence.countFindCorrespondencesByCompanyIdEquals(companyId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByCompanyIdEquals(companyId, sortFieldName, sortOrder).getResultList());
        }
        return "correspondences/list";
    }
    
    @RequestMapping(params = { "find=ByOrginallicenceIdEquals", "form" }, method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByOrginallicenceIdEqualsForm(Model uiModel) {
        return "correspondences/findCorrespondencesByOrginallicenceIdEquals";
    }
    
    @RequestMapping(params = "find=ByOrginallicenceIdEquals", method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesByOrginallicenceIdEquals(@RequestParam("orginallicenceId") Long orginallicenceId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByOrginallicenceIdEquals(orginallicenceId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Correspondence.countFindCorrespondencesByOrginallicenceIdEquals(orginallicenceId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesByOrginallicenceIdEquals(orginallicenceId, sortFieldName, sortOrder).getResultList());
        }
        return "correspondences/list";
    }
    
    @RequestMapping(params = { "find=BySeqcorrId", "form" }, method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesBySeqcorrIdForm(Model uiModel) {
        return "correspondences/findCorrespondencesBySeqcorrId";
    }
    
    @RequestMapping(params = "find=BySeqcorrId", method = RequestMethod.GET)
    public String CorrespondenceController.findCorrespondencesBySeqcorrId(@RequestParam("seqcorrId") Long seqcorrId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesBySeqcorrId(seqcorrId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Correspondence.countFindCorrespondencesBySeqcorrId(seqcorrId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correspondences", Correspondence.findCorrespondencesBySeqcorrId(seqcorrId, sortFieldName, sortOrder).getResultList());
        }
        return "correspondences/list";
    }
    
}