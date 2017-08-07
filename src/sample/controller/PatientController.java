package sample.controller;

import java.io.BufferedReader;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.PatientDto;
import sample.service.PatientService;

public class PatientController extends Controller {
    
    /**
     * Service object that will be used to call CRUD functions to datastore
     */
    PatientService PatientService = new PatientService();
    
    /**
     * For now, used to insert a 'Patient' entity to the datastore
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("PatientController.run start");
        
        
        
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
            PatientDto PatientDto = new PatientDto(jObj.getString("fname"),
                                                jObj.getString("lname"),
                                                jObj.getString("address"),
                                                jObj.getString("specialization"),
                                                jObj.getString("number"),
                                                jObj.getString("birthday"),
                                                jObj.getString("username"),
                                                jObj.getString("password")
                                               );
            
            
            PatientService.insertPat(PatientDto);
        }catch(Exception e){
            System.out.println("PatientController.run.exception: "+e.toString());
        }
        
        System.out.println("PatientController.run end");
        //screen redirection.
        return forward("/app/components/editPatient/editPatient.html/");
    }
}
