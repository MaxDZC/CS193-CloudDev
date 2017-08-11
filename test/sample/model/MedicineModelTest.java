package sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MedicineModelTest extends AppEngineTestCase {

    private MedicineModel model = new MedicineModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
