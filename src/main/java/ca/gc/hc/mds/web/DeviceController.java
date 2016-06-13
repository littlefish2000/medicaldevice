package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Device;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;

@RequestMapping("/devices")
@Controller
@RooWebScaffold(path = "devices", formBackingObject = Device.class)
@RooWebFinder
@GvNIXWebJQuery
public class DeviceController {
}
