package sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.DiseaseDto;
import sample.meta.DiseaseModelMeta;
import sample.model.DiseaseModel;
import sample.service.DiseaseService;
import sample.utils.JSONValidators;

public class DiseaseController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Boolean message;
        JSONValidators validator;
        Object checkObj;
        String[] createdAts;
        String[] updatedAts;
        String createdAt;
        String updatedAt;
        Date createdAtNew;
        Date updatedAtNew;
        
        DiseaseDto diseaseDto = new DiseaseDto();
        DiseaseModel diseaseModel;
        String method = request.getMethod();
        JSONObject jsonObject = new JSONObject();
        DiseaseService diseaseService = new DiseaseService();
        
        try{
            if("POST".equalsIgnoreCase(method)){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    diseaseDto = new DiseaseDto(jsonObject);
                    diseaseDto.setCreatedAt(new Date());
                    
                    if(!diseaseService.insertDisease(diseaseDto)){
                        response.setStatus(400);
                    }
                }
            }  else if(method.equals("GET")) {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("name")) {
                    diseaseModel = diseaseService.getDisease(jsonObject.getString("name"));
                    
                    if(diseaseModel != null) {
                        jsonObject.put("disease", DiseaseModelMeta.get().modelToJson(diseaseModel));
                    } else {
                        response.setStatus(400);
                    }
                } else {
                    System.out.println("Getting All Diseases");
                    jsonObject.put("diseases", diseaseService.getAllDisease());
                }
                
            } else if(method.equals("PUT")) {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    diseaseDto = new DiseaseDto(jsonObject);
                    checkObj = jsonObject.get("createdAt");
                    
                    if(checkObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        diseaseDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        diseaseDto.setCreatedAt(createdAtNew);
                    }
                    
                    diseaseDto.setId(jsonObject.getLong("id"));
                    diseaseDto.setUpdatedAt(new Date());
                    
                    message = diseaseService.updateDisease(diseaseDto);
                    
                    if(message){
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", !message);
                        response.setStatus(400);
                    }
                }
                    
            } else if(method.equals("DELETE")) {
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){               
                    
                    diseaseDto = new DiseaseDto(jsonObject);
                    checkObj = jsonObject.get("createdAt");
                    
                    if(checkObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        diseaseDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAts = jsonObject.getString("updatedAt").split(" ");
                            updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                            diseaseDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                        }
                        
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));            
                        diseaseDto.setCreatedAt(createdAtNew);
                        
                        if(jsonObject.has("updatedAt")){ 
                            updatedAtNew = new Date(jsonObject.getLong("updated At")); 
                            diseaseDto.setUpdatedAt(updatedAtNew);
                        }
                    }
                    
                    diseaseDto.setId(jsonObject.getLong("id"));
                    diseaseDto.setDeletedAt(new Date());
                    
                    message = diseaseService.deleteDisease(diseaseDto);
                    
                    if(message){
                        jsonObject.put("success", true);    
                    } else {
                        response.setStatus(400);
                        jsonObject.put("errors", !message);
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        return null;
    }           
}
