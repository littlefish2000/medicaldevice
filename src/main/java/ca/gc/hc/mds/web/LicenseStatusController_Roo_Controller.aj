// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.LicenseStatus;
import ca.gc.hc.mds.web.LicenseStatusController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect LicenseStatusController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String LicenseStatusController.create(@Valid LicenseStatus licenseStatus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, licenseStatus);
            return "maintenance/codetable/licenseStatus/create";
        }
        uiModel.asMap().clear();
        licenseStatus.persist();
        return "redirect:/maintenance/codetable/licenseStatus/" + encodeUrlPathSegment(licenseStatus.getLicencestatusCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String LicenseStatusController.createForm(Model uiModel) {
        populateEditForm(uiModel, new LicenseStatus());
        return "maintenance/codetable/licenseStatus/create";
    }
    
    @RequestMapping(value = "/{licencestatusCd}", produces = "text/html")
    public String LicenseStatusController.show(@PathVariable("licencestatusCd") String licencestatusCd, Model uiModel) {
        uiModel.addAttribute("licensestatus", LicenseStatus.findLicenseStatus(licencestatusCd));
        uiModel.addAttribute("itemId", licencestatusCd);
        return "maintenance/codetable/licenseStatus/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String LicenseStatusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("licensestatuses", LicenseStatus.findLicenseStatusEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) LicenseStatus.countLicenseStatuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("licensestatuses", LicenseStatus.findAllLicenseStatuses(sortFieldName, sortOrder));
        }
        return "maintenance/codetable/licenseStatus/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String LicenseStatusController.update(@Valid LicenseStatus licenseStatus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, licenseStatus);
            return "maintenance/codetable/licenseStatus/update";
        }
        uiModel.asMap().clear();
        licenseStatus.merge();
        return "redirect:/maintenance/codetable/licenseStatus/" + encodeUrlPathSegment(licenseStatus.getLicencestatusCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{licencestatusCd}", params = "form", produces = "text/html")
    public String LicenseStatusController.updateForm(@PathVariable("licencestatusCd") String licencestatusCd, Model uiModel) {
        populateEditForm(uiModel, LicenseStatus.findLicenseStatus(licencestatusCd));
        return "maintenance/codetable/licenseStatus/update";
    }
    
    @RequestMapping(value = "/{licencestatusCd}", method = RequestMethod.DELETE, produces = "text/html")
    public String LicenseStatusController.delete(@PathVariable("licencestatusCd") String licencestatusCd, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        LicenseStatus licenseStatus = LicenseStatus.findLicenseStatus(licencestatusCd);
        licenseStatus.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/licenseStatus";
    }
    
    void LicenseStatusController.populateEditForm(Model uiModel, LicenseStatus licenseStatus) {
        uiModel.addAttribute("licenseStatus", licenseStatus);
    }
    
    String LicenseStatusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
