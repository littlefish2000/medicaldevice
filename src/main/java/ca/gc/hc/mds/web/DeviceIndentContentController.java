package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.DeviceIndentContent;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.DeviceIndentContentBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/codetable/deviceindentcontent")
@Controller
@RooWebScaffold(path = "maintenance/codetable/deviceindentcontent", formBackingObject = DeviceIndentContent.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = DeviceIndentContentBatchService.class)
@GvNIXDatatables(ajax = true)
public class DeviceIndentContentController {
}
