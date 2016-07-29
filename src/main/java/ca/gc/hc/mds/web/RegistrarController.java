package ca.gc.hc.mds.web;
import ca.gc.hc.mds.domain.Registrar;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.annotations.jquery.GvNIXWebJQuery;
import ca.gc.hc.mds.domain.RegistrarBatchService;
import org.gvnix.addon.web.mvc.annotations.batch.GvNIXWebJpaBatch;
import org.gvnix.addon.datatables.annotations.GvNIXDatatables;

@RequestMapping("/maintenance/Registrar")
@Controller
@RooWebScaffold(path = "maintenance/Registrar", formBackingObject = Registrar.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = RegistrarBatchService.class)
@GvNIXDatatables(ajax = true)
public class RegistrarController {
}
