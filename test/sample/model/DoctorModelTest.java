package sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DoctorModelTest extends AppEngineTestCase {

    private DoctorModel model = new DoctorModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
