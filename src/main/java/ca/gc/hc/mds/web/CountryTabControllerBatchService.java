package ca.gc.hc.mds.web;
import org.gvnix.addon.jpa.annotations.batch.GvNIXJpaBatch;
import org.springframework.stereotype.Service;

@Service
@GvNIXJpaBatch(entity = CountryTabController.class)
public class CountryTabControllerBatchService {
}
