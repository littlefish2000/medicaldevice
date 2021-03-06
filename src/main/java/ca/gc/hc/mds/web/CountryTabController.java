package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.CountryTab;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.CountryTabBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/codetable/countrytab")
@Controller
@RooWebScaffold(path = "maintenance/codetable/countrytab", formBackingObject = CountryTab.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = CountryTabBatchService.class)
@GvNIXDatatables(ajax = true)
public class CountryTabController {
}
