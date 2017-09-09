package sample.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DoctorServiceTest extends AppEngineTestCase {

    private DoctorService service = new DoctorService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
