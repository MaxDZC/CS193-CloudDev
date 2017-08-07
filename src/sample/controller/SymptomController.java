package sample.controller;

import java.io.BufferedReader;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.SymptomDto;
import sample.service.SymptomService;

public class SymptomController extends Controller {
    
    /**
     * Service object that will be used to call CRUD functions to datastore
     */
    SymptomService SymptomService = new SymptomService();
    
    /**
     * For now, used to insert a 'Symptom' entity to the datastore
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("SymptomController.run start");
        
        
        
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
            SymptomDto SymptomDto = new SymptomDto(jObj.getString("name")
                                                
                                               
                                               );
            
            
            SymptomService.insertSymp(SymptomDto);
        }catch(Exception e){
            System.out.println("SymptomController.run.exception: "+e.toString());
        }
        
        System.out.println("SymptomController.run end");
        //screen redirection.
        return forward("/app/components/editSymptom/editSymptom.html/");
    }
}
