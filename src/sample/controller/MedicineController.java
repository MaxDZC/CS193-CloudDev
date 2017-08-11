package sample.controller;

import java.io.BufferedReader;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.MedicineDto;
import sample.service.MedicineService;

public class MedicineController extends Controller {
    
    MedicineService medicineService = new MedicineService();
    
    @Override
    protected Navigation run() throws Exception {
        System.out.println("MedicineController.run start");
        
        try{
            BufferedReader br = request.getReader();
            String str = null;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            
            MedicineDto medicineDto = new MedicineDto(jObj.getString("name"),
                                                      jObj.getString("desc"),
                                                      Double.parseDouble(jObj.getString("price"))
                                                     );
            medicineService.insertMed(medicineDto);
        }catch(Exception e){
            System.out.println("MedicineController.run.exception: "+e.toString());
        }
        
        System.out.println("MedicineController.run end");
        
        return forward("/app/components/exploremedicines/exploremedicines.html/");
    }
}
