package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.CompanyHistory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;

@RequestMapping("/companyhistorys")
@Controller
@RooWebScaffold(path = "companyhistorys", formBackingObject = CompanyHistory.class)
@RooWebFinder
@GvNIXWebJQuery
public class CompanyHistoryController {
}
