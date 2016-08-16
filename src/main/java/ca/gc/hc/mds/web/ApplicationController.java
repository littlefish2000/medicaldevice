package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Application;
import ca.gc.hc.mds.domain.DeviceMaterial;
import ca.gc.hc.mds.reference.ApplicationType;
import ca.gc.hc.mds.reference.DevLicenceType;
import ca.gc.hc.mds.reference.LicenceStatusType;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import org.joda.time.format.DateTimeFormat;

@RequestMapping("/applications")
@Controller
@RooWebScaffold(path = "applications", formBackingObject = Application.class)
@RooWebFinder
@GvNIXWebJQuery
public class ApplicationController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Application application, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, application);
            return "applications/create";
        }
        uiModel.asMap().clear();
        application.persist();
        return "redirect:/applications/" + encodeUrlPathSegment(application.getApplicationId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Application());
        return "applications/create";
    }

	@RequestMapping(value = "/{applicationId}", produces = "text/html")
    public String show(@PathVariable("applicationId") Long applicationId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("application", Application.findApplication(applicationId));
        uiModel.addAttribute("itemId", applicationId);
        return "applications/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("applications", Application.findApplicationEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Application.countApplications() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("applications", Application.findAllApplications(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "applications/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Application application, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, application);
            return "applications/update";
        }
        uiModel.asMap().clear();
        application.merge();
        return "redirect:/applications/" + encodeUrlPathSegment(application.getApplicationId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{applicationId}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("applicationId") Long applicationId, Model uiModel) {
        populateEditForm(uiModel, Application.findApplication(applicationId));
        return "applications/update";
    }

	@RequestMapping(value = "/{applicationId}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("applicationId") Long applicationId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Application application = Application.findApplication(applicationId);
        application.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/applications";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("application_entrydate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("application_receiptdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("application_licencestatusdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("application_devicematerial_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Application application) {
        uiModel.addAttribute("application", application);
        uiModel.addAttribute("tranDeviceMaterial", DeviceMaterial.findDeviceMaterialForApplication(application.getApplicationId(), application.getOrginLicenseId()));
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("applicationtypes", Arrays.asList(ApplicationType.values()));
        uiModel.addAttribute("devlicencetypes", Arrays.asList(DevLicenceType.values()));
        uiModel.addAttribute("licencestatustypes", Arrays.asList(LicenceStatusType.values()));
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

	@RequestMapping(params = { "find=ByApplicationId", "form" }, method = RequestMethod.GET)
    public String findApplicationsByApplicationIdForm(Model uiModel) {
        return "applications/findApplicationsByApplicationId";
    }

	@RequestMapping(params = "find=ByApplicationId", method = RequestMethod.GET)
    public String findApplicationsByApplicationId(@RequestParam("applicationId") Long applicationId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("applications", Application.findApplicationsByApplicationId(applicationId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Application.countFindApplicationsByApplicationId(applicationId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("applications", Application.findApplicationsByApplicationId(applicationId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "applications/list";
    }

	@RequestMapping(params = { "find=ByOrginLicenseId", "form" }, method = RequestMethod.GET)
    public String findApplicationsByOrginLicenseIdForm(Model uiModel) {
        return "applications/findApplicationsByOrginLicenseId";
    }

	@RequestMapping(params = "find=ByOrginLicenseId", method = RequestMethod.GET)
    public String findApplicationsByOrginLicenseId(@RequestParam("orginLicenseId") long orginLicenseId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("applications", Application.findApplicationsByOrginLicenseId(orginLicenseId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Application.countFindApplicationsByOrginLicenseId(orginLicenseId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("applications", Application.findApplicationsByOrginLicenseId(orginLicenseId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "applications/list";
    }
}
