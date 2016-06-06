package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.CompanyContact;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/companycontacts")
@Controller
@RooWebScaffold(path = "companycontacts", formBackingObject = CompanyContact.class)
@RooWebFinder
public class CompanyContactController {
}
