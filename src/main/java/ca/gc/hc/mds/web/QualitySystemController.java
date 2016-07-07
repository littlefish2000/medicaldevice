package ca.gc.hc.mds.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import ca.gc.hc.mds.domain.Certificate;
import ca.gc.hc.mds.reference.CertificateStatusType;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

//@RequestMapping("/qualitysystem/certificates")
@Controller
@RooWebFinder
@RooWebScaffold(path = "qualitysystem/certificates", formBackingObject = Certificate.class)
public class QualitySystemController {

	private ConversionService conversionService;

	@Autowired
    public QualitySystemController(ConversionService conversionService) {
        super();
        this.conversionService = conversionService;
    }
		
	
	@RequestMapping(value = "/qualitysystem/certificates", params = { "find=ByCertificateIdLike", "form" }, method = RequestMethod.GET)
    public String findCertificatesByCertificateIdLikeForm(Model uiModel) {
        return "qualitysystem/certificates/findCertificatesByCertificateIdLike";
    }

	@RequestMapping(value = "/qualitysystem/certificates", params = "find=ByCertificateIdLike", method = RequestMethod.GET)
    public String findCertificatesByCertificateIdLike(@RequestParam("certificateId") String certificateId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("certificates", Certificate.findCertificatesByCertificateIdLike(certificateId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Certificate.countFindCertificatesByCertificateIdLike(certificateId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("certificates", Certificate.findCertificatesByCertificateIdLike(certificateId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "qualitysystem/certificates/list";
    }

	@RequestMapping(value = "/qualitysystem/certificates", params = { "find=ByOrigcertificateIdLike", "form" }, method = RequestMethod.GET)
    public String findCertificatesByOrigcertificateIdLikeForm(Model uiModel) {
        return "qualitysystem/certificates/findCertificatesByOrigcertificateIdLike";
    }

	@RequestMapping(value = "/qualitysystem/certificates", params = "find=ByOrigcertificateIdLike", method = RequestMethod.GET)
    public String findCertificatesByOrigcertificateIdLike(@RequestParam("origcertificateId") String origcertificateId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("certificates", Certificate.findCertificatesByOrigcertificateIdLike(origcertificateId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Certificate.countFindCertificatesByOrigcertificateIdLike(origcertificateId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("certificates", Certificate.findCertificatesByOrigcertificateIdLike(origcertificateId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "qualitysystem/certificates/list";
    }

	@RequestMapping(value = "/qualitysystem/certificates", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Certificate certificate, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, certificate);
            //return "qualitysystem/certificates/create";
            return "qualitysystem/cert/new";
        }
        uiModel.asMap().clear();
        certificate.persist();
        return "redirect:/qualitysystem/certificates/" + encodeUrlPathSegment(certificate.getOrigcertificateId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/qualitysystem/certificates", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Certificate());
        //return "qualitysystem/certificates/create";
        return "qualitysystem/cert/new";
    }

	@RequestMapping(value = "/qualitysystem/certificates/{origcertificateId}", produces = "text/html")
    public String show(@PathVariable("origcertificateId") String origcertificateId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("certificate", Certificate.findCertificate(origcertificateId));
        uiModel.addAttribute("itemId", origcertificateId);
        return "qualitysystem/certificates/show";
    }

	@RequestMapping(value = "/qualitysystem/certificates",produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("certificates", Certificate.findCertificateEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Certificate.countCertificates() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("certificates", Certificate.findAllCertificates(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "qualitysystem/certificates/list";
    }

	@RequestMapping(value = "/qualitysystem/certificates",method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Certificate certificate, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, certificate);
            //return "qualitysystem/certificates/update";
            return "qualitysystem/cert/update";
        }
        uiModel.asMap().clear();
        certificate.merge();
        return "redirect:/qualitysystem/certificates/" + encodeUrlPathSegment(certificate.getOrigcertificateId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/qualitysystem/certificates/{origcertificateId}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("origcertificateId") String origcertificateId, Model uiModel) {
        populateEditForm(uiModel, Certificate.findCertificate(origcertificateId));
        //return "qualitysystem/certificates/update";
        return "qualitysystem/cert/update";
    }

	@RequestMapping(value = "/qualitysystem/certificates/{origcertificateId}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("origcertificateId") String origcertificateId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Certificate certificate = Certificate.findCertificate(origcertificateId);
        certificate.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/qualitysystem/certificates";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("certificate_statusdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("certificate_receiptdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("certificate_entrydate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Certificate certificate) {
        uiModel.addAttribute("certificate", certificate);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("certificatestatustypes", Arrays.asList(CertificateStatusType.values()));
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
	
	
	@RequestMapping(value = "/qualitysystem/validity", params = { "batchtracking", "form" }, method = RequestMethod.GET)
    public String findBatchControl(Model uiModel) {
        return "qualitysystem/validity/batchtracking";
    }	
	@RequestMapping(value = "/qualitysystem/validity/batchcontrols", params = "form", produces = "text/html")
    public String createNewBatchControlForm(Model uiModel) {
        //populateEditForm(uiModel, new Certificate());
        return "qualitysystem/validity/batchcontrolupdate";
    }	
	
}
