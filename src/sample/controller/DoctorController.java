package sample.controller;

import java.io.BufferedReader;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.DoctorDto;
import sample.service.DoctorService;

public class DoctorController extends Controller {
    
    /**
     * Service object that will be used to call CRUD functions to datastore
     */
    DoctorService doctorService = new DoctorService();
    
    /**
     * For now, used to insert a 'doctor' entity to the datastore
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("DoctorController.run start");
     // SendMail.send();
      boolean exist = false ; 
        
        
        try{
            /**
             * Used to retrieve the JSON equivalent data
             */
            BufferedReader br = request.getReader();
            String str = null;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            
            /**
             * Used to store the information from the request and send to the
             * service class.
             */
            DoctorDto doctorDto = new DoctorDto(jObj.getString("fname"),
                                                jObj.getString("lname"),
                                                jObj.getString("address"),
                                                jObj.getString("specialization"),
                                                ""+jObj.getInt("number")+"",
                                                jObj.getString("birthday"),
                                                jObj.getString("username"),
                                                jObj.getString("password"),
                                                jObj.getString("email")
                                               );
            
            
            if(doctorService.insertDoc(doctorDto) == false){
                return forward("/app/shared/parts/actions/exist.html");
            } 
        }catch(Exception e){
            System.out.println("DoctorController.run.exception: "+e.toString());
            return forward("/app/shared/parts/actions/failed.html");
        }
        
        System.out.println("DoctorController.run end");
        //screen redirection.
        return forward("/app/shared/parts/actions/success.html");
    }
}
