package sample.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.PatientDto;
import sample.service.PatientService;

public class PatientController extends Controller {
    
    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    PatientService patientService = new PatientService();
    
    
    /**
    * For now, used to insert a 'patient' entity to the datastore
    */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("PatientController.run start");
        
        JSONObject json = new JSONObject();
        String method = request.getMethod();
        JSONObject jObj = null;
        PatientDto patientDto = null ;
        
        if(method == "POST"){
            
            /**
            * Used to retrieve the JSON equivalent data
            */
            BufferedReader br = request.getReader();
            String str = null;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            jObj = new JSONObject(this.request.getReader().readLine());
            
            /**
            * Used to store the information from the request and send to the
            * service class.
            */
            patientDto = new PatientDto(jObj.getString("firstName"),
            jObj.getString("lastName"),
            jObj.getString("address"),
            jObj.getString("email"),
            jObj.getString("number"),
            jObj.getString("birthday")
            );
            patientDto.setCreatedaAt(new Date());
            
                
                
                if (patientService.insertPat(patientDto) == false) {
                    
                    json.put("message", "duplicated");
                    
                  } else {
                    
                    json.put("message", true);
                    
                }
                
           } else if (method == "PUT") {
               jObj = new JSONObject(this.request.getReader().readLine());
               
                   patientDto = new PatientDto(jObj.getString("firstName"),
                   jObj.getString("lastName"),
                   jObj.getString("address"),
                   jObj.getString("email"),
                   jObj.getString("number"),
                   jObj.getString("birthday")
                   );
                   patientDto.setId(Long.parseLong(jObj.getString("id")));
                
                
                if (PatientService.updatePatient(patientDto)) {
                    json.put("message", "The Profil of  " + jObj.getString("lastName") + " was updated ");
                   } else {
                    json.put("message", false);
                }
                
                } else if (method == "DELETE") {
               
                    if (PatientService.deletePatient(patientDto)) {
                    
                    json.put("message", "The Profil of was deleted ");
                    } else {
                    json.put("message", false);
                }
                
            }  else if (method == "GET") {
            if(this.request.getParameter("id") != null){
                json.put("patients", PatientService.getPatient(Long.parseLong(this.request.getParameter("id"))));
                } else  {
                json.put("patients", PatientService.getPatients());
            }
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //print JSon
        out.print(json.toString());
        
        System.out.println("PatientController.run end");
        //screen redirection.
        return null;
    }
    
}