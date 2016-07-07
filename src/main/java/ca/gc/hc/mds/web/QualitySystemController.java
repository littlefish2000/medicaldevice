package ca.gc.hc.mds.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.gc.hc.mds.domain.Certificate;

import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RequestMapping("/qualitysystem/certificates")
@Controller
@RooWebFinder
@RooWebScaffold(path = "qualitysystem/certificates", formBackingObject = Certificate.class)
public class QualitySystemController {
}
