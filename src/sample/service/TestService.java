package sample.service;

import sample.dao.TestDao;
import sample.model.Tweet;

public class TestService {
    TestDao dao = new TestDao();

    public Tweet getContent() {
        return this.dao.getContent();
    }
}
