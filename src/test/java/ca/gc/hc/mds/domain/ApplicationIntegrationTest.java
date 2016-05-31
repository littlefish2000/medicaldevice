package ca.gc.hc.mds.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

@RooIntegrationTest(entity = Application.class,findAll=false,persist=false,remove=false)
@ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext*.xml"})

public class ApplicationIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
