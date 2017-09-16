package sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DoctorTest extends AppEngineTestCase {

    private Doctor model = new Doctor();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
