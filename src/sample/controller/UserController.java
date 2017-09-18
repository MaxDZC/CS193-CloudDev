package sample.controller;




import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.service.UserService;


public class UserController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    UserService userService = new UserService();

    @Override
    protected Navigation run() throws Exception {
        JSONObject jsonObject = null;
       
        
        return null;}
    
}