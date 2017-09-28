package sample.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DiseaseModelDaoTest extends AppEngineTestCase {

    private DiseaseModelDao dao = new DiseaseModelDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
