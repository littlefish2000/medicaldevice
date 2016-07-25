package ca.gc.hc.mds.web;

import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.gc.hc.mds.domain.PreferredNameCode;

@RequestMapping("preferredNameCodes")
@Controller
@RooWebScaffold(path = "preferredNameCodes", formBackingObject = PreferredNameCode.class)
@RooWebFinder
@GvNIXWebJQuery
public class PreferredNameCodeController {

}
