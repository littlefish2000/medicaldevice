package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Division;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.DivisionBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/codetable/division")
@Controller
@RooWebScaffold(path = "maintenance/codetable/division", formBackingObject = Division.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = DivisionBatchService.class)
@GvNIXDatatables(ajax = true)
public class DivisionController {
}
