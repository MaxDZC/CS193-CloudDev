package sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dao.MedicalRecordDao;
import sample.dto.MedicalRecordDto;
import sample.service.MedicalRecordService;



public class MedicalRecordController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("MedicalRecordController.run start");
        
        String method = request.getMethod();
        JSONObject jObj = null;
        MedicalRecordDto medicalRecordDto = null;
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        String date;
        
        try{
            if(method.equalsIgnoreCase("POST")){
                jObj = new JSONObject(request.getReader().readLine());
                
                medicalRecordDto = new MedicalRecordDto(jObj);
                
                medicalRecordDto.setCreatedAt(new Date());
                medicalRecordDto.setUpdatedAt(null);
                medicalRecordDto.setDeletedAt(null);
                
                medicalRecordService.insertMedicalRecord(medicalRecordDto);
            }else if(method.equalsIgnoreCase("PUT")){
                jObj = new JSONObject(request.getReader().readLine());
                date = MedicalRecordDao.processDate(jObj.getString("createdAt"));
                
                medicalRecordDto = new MedicalRecordDto(jObj);
                
                medicalRecordDto.setId(jObj.getLong("id"));
                medicalRecordDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(date));
                medicalRecordDto.setUpdatedAt(new Date());
                medicalRecordDto.setDeletedAt(null);
                
                medicalRecordService.deleteOrUpdateMedicalRecord(medicalRecordDto);
            }else if(method.equalsIgnoreCase("DELETE")){
                jObj = new JSONObject(request.getReader().readLine());
                date = MedicalRecordDao.processDate(jObj.getString("createdAt"));
                
                medicalRecordDto = new MedicalRecordDto(jObj);
                
                medicalRecordDto.setId(jObj.getLong("id"));
                medicalRecordDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(date));
                date = MedicalRecordDao.processDate(jObj.getString("updatedAt"));
                medicalRecordDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(date));
                medicalRecordDto.setDeletedAt(new Date());
                
                medicalRecordService.deleteOrUpdateMedicalRecord(medicalRecordDto);
            
            }else if(method.equalsIgnoreCase("GET")){
                
            }
            System.out.println("MedicalRecordController.run end");
        }catch(Exception e){
            System.out.println("MedicalRecordController Exception: "+e.toString());
            
        }
        return null;
    }
}
