package sample.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MedicalRecordServiceTest extends AppEngineTestCase {

    private MedicalRecordService service = new MedicalRecordService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
