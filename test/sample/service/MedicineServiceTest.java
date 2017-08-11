package sample.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MedicineServiceTest extends AppEngineTestCase {

    private MedicineService service = new MedicineService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
