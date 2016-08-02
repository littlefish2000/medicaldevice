package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.DrugStandard;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.DrugStandardBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/codetable/drugstandard")
@Controller
@RooWebScaffold(path = "maintenance/codetable/drugstandard", formBackingObject = DrugStandard.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = DrugStandardBatchService.class)
@GvNIXDatatables(ajax = true)
public class DrugStandardController {
}
