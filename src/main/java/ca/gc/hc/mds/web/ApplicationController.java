package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Application;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;

@RequestMapping("/applications")
@Controller
@RooWebScaffold(path = "applications", formBackingObject = Application.class)
@RooWebFinder
@GvNIXWebJQuery
public class ApplicationController {
}
