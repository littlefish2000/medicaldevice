package ca.gc.hc.mds.domain;
import org.gvnix.addon.jpa.annotations.batch.GvNIXJpaBatch;
import org.springframework.stereotype.Service;

@Service
@GvNIXJpaBatch(entity = Registrar.class)
public class RegistrarBatchService {
}
