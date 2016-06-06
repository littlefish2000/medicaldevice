package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Device;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/devices")
@Controller
@RooWebScaffold(path = "devices", formBackingObject = Device.class)
@RooWebFinder
public class DeviceController {
}
