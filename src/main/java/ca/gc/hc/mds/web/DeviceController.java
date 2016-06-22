package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Device;
import java.io.UnsupportedEncodingException;
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

@RequestMapping("/devices")
@Controller
@RooWebScaffold(path = "devices", formBackingObject = Device.class)
@RooWebFinder
@GvNIXWebJQuery
public class DeviceController {

	@RequestMapping(params = { "find=ByDeviceId", "form" }, method = RequestMethod.GET)
    public String findDevicesByDeviceIdForm(Model uiModel) {
        return "devices/findDevicesByDeviceId";
    }

	@RequestMapping(params = "find=ByDeviceId", method = RequestMethod.GET)
    public String findDevicesByDeviceId(@RequestParam("deviceId") Long deviceId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("devices", Device.findDevicesByDeviceId(deviceId, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Device.countFindDevicesByDeviceId(deviceId) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("devices", Device.findDevicesByDeviceId(deviceId, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "devices/list";
    }

	@RequestMapping(params = { "find=ByPerfnameCode", "form" }, method = RequestMethod.GET)
    public String findDevicesByPerfnameCodeForm(Model uiModel) {
        return "devices/findDevicesByPerfnameCode";
    }

	@RequestMapping(params = "find=ByPerfnameCode", method = RequestMethod.GET)
    public String findDevicesByPerfnameCode(@RequestParam("perfnameCode") String perfnameCode, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("devices", Device.findDevicesByPerfnameCode(perfnameCode, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Device.countFindDevicesByPerfnameCode(perfnameCode) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("devices", Device.findDevicesByPerfnameCode(perfnameCode, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "devices/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Device device, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, device);
            return "devices/create";
        }
        uiModel.asMap().clear();
        device.persist();
        return "redirect:/devices/" + encodeUrlPathSegment(device.getDeviceId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Device());
        //return "devices/create";
        return "devices/update";
    }

	@RequestMapping(value = "/{deviceId}", produces = "text/html")
    public String show(@PathVariable("deviceId") Long deviceId, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("device", Device.findDevice(deviceId));
        uiModel.addAttribute("itemId", deviceId);
        return "devices/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("devices", Device.findDeviceEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Device.countDevices() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("devices", Device.findAllDevices(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "devices/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Device device, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, device);
            return "devices/update";
        }
        uiModel.asMap().clear();
        device.merge();
        return "redirect:/devices/" + encodeUrlPathSegment(device.getDeviceId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{deviceId}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("deviceId") Long deviceId, Model uiModel) {
        populateEditForm(uiModel, Device.findDevice(deviceId));
        return "devices/update";
    }

	@RequestMapping(value = "/{deviceId}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("deviceId") Long deviceId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Device device = Device.findDevice(deviceId);
        device.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/devices";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("device_entrydate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("device_lastchangedate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Device device) {
        uiModel.addAttribute("device", device);
        addDateTimeFormatPatterns(uiModel);
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
}
