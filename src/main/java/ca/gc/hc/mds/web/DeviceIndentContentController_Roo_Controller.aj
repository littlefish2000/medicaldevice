// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.DeviceIndentContent;
import ca.gc.hc.mds.web.DeviceIndentContentController;
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

privileged aspect DeviceIndentContentController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String DeviceIndentContentController.create(@Valid DeviceIndentContent deviceIndentContent, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, deviceIndentContent);
            return "maintenance/codetable/deviceindentcontent/create";
        }
        uiModel.asMap().clear();
        deviceIndentContent.persist();
        return "redirect:/maintenance/codetable/deviceindentcontent/" + encodeUrlPathSegment(deviceIndentContent.getDeviceidentcontentCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String DeviceIndentContentController.createForm(Model uiModel) {
        populateEditForm(uiModel, new DeviceIndentContent());
        return "maintenance/codetable/deviceindentcontent/create";
    }
    
    @RequestMapping(value = "/{deviceidentcontentCd}", produces = "text/html")
    public String DeviceIndentContentController.show(@PathVariable("deviceidentcontentCd") String deviceidentcontentCd, Model uiModel) {
        uiModel.addAttribute("deviceindentcontent", DeviceIndentContent.findDeviceIndentContent(deviceidentcontentCd));
        uiModel.addAttribute("itemId", deviceidentcontentCd);
        return "maintenance/codetable/deviceindentcontent/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String DeviceIndentContentController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("deviceindentcontents", DeviceIndentContent.findDeviceIndentContentEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) DeviceIndentContent.countDeviceIndentContents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("deviceindentcontents", DeviceIndentContent.findAllDeviceIndentContents(sortFieldName, sortOrder));
        }
        return "maintenance/codetable/deviceindentcontent/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String DeviceIndentContentController.update(@Valid DeviceIndentContent deviceIndentContent, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, deviceIndentContent);
            return "maintenance/codetable/deviceindentcontent/update";
        }
        uiModel.asMap().clear();
        deviceIndentContent.merge();
        return "redirect:/maintenance/codetable/deviceindentcontent/" + encodeUrlPathSegment(deviceIndentContent.getDeviceidentcontentCd().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{deviceidentcontentCd}", params = "form", produces = "text/html")
    public String DeviceIndentContentController.updateForm(@PathVariable("deviceidentcontentCd") String deviceidentcontentCd, Model uiModel) {
        populateEditForm(uiModel, DeviceIndentContent.findDeviceIndentContent(deviceidentcontentCd));
        return "maintenance/codetable/deviceindentcontent/update";
    }
    
    @RequestMapping(value = "/{deviceidentcontentCd}", method = RequestMethod.DELETE, produces = "text/html")
    public String DeviceIndentContentController.delete(@PathVariable("deviceidentcontentCd") String deviceidentcontentCd, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        DeviceIndentContent deviceIndentContent = DeviceIndentContent.findDeviceIndentContent(deviceidentcontentCd);
        deviceIndentContent.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/maintenance/codetable/deviceindentcontent";
    }
    
    void DeviceIndentContentController.populateEditForm(Model uiModel, DeviceIndentContent deviceIndentContent) {
        uiModel.addAttribute("deviceIndentContent", deviceIndentContent);
    }
    
    String DeviceIndentContentController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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