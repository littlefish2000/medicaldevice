// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ca.gc.hc.mds.web;

import ca.gc.hc.mds.domain.Device;
import ca.gc.hc.mds.web.DeviceController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect DeviceController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByPerfnameCodeLike", "form" }, method = RequestMethod.GET)
    public String DeviceController.findDevicesByPerfnameCodeLikeForm(Model uiModel) {
        return "devices/findDevicesByPerfnameCodeLike";
    }
    
    @RequestMapping(params = "find=ByPerfnameCodeLike", method = RequestMethod.GET)
    public String DeviceController.findDevicesByPerfnameCodeLike(@RequestParam("perfnameCode") String perfnameCode, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("devices", Device.findDevicesByPerfnameCodeLike(perfnameCode, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Device.countFindDevicesByPerfnameCodeLike(perfnameCode) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("devices", Device.findDevicesByPerfnameCodeLike(perfnameCode, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "devices/list";
    }
    
}
