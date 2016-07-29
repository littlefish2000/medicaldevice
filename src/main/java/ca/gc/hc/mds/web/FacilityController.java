package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Facility;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.FacilityBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/facilitys")
@Controller
@RooWebScaffold(path = "maintenance/facilitys", formBackingObject = Facility.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = FacilityBatchService.class)
@GvNIXDatatables(ajax = true)
public class FacilityController {
}
