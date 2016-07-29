package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Physician;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.PhysicianBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/physicians")
@Controller
@RooWebScaffold(path = "maintenance/physicians", formBackingObject = Physician.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = PhysicianBatchService.class)
@GvNIXDatatables(ajax = true)
public class PhysicianController {
}
