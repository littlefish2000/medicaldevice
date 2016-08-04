package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.LicenseStatus;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.LicenseStatusBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/codetable/licenseStatus")
@Controller
@RooWebScaffold(path = "maintenance/codetable/licenseStatus", formBackingObject = LicenseStatus.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = LicenseStatusBatchService.class)
@GvNIXDatatables(ajax = true)
public class LicenseStatusController {
}
