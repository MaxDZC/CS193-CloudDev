package sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DiseaseModelTest extends AppEngineTestCase {

    private DiseaseModel model = new DiseaseModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
