package sample.controller.test;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import sample.model.Tweet;
import sample.service.TestService;

public class IndexController extends Controller {

    TestService service = new TestService();

    @Override
    public Navigation run() throws Exception {
        System.out.println("TEST");
        Tweet tweet = service.getContent();
        requestScope("tweet", tweet);
        return forward("index.jsp");
    }
}
