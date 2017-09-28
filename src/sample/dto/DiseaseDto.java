package sample.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONObject;


public class DiseaseDto extends ErrorsDto {
    private Long id;
    private String name;
    private List<Long> symptomId;
    private List<Long> medicineId;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    
    public DiseaseDto (JSONObject jObj) throws Exception{
        
        JSONArray sympId;
        JSONArray medId;
        int i;
        List<Long> idsymptoms = new ArrayList<Long>();
        List<Long> idmedicines = new ArrayList<Long>();
        
        sympId = jObj.getJSONArray("symptomId");
        medId = jObj.getJSONArray("medicineId");
        
        if(sympId.get(0) instanceof JSONObject) {
            for(i = 0; i < sympId.length(); i++){
                idsymptoms.add(sympId.getJSONObject(i).getLong("id"));
            }
        } else {
            for(i = 0; i < sympId.length(); i++){
                idsymptoms.add(sympId.getLong(i));
            }
        }
        
        if(medId.get(0) instanceof JSONObject){
            for(i = 0; i < medId.length(); i++){
                idmedicines.add(medId.getJSONObject(i).getLong("id"));
            }
        } else {
            for(i = 0; i < medId.length(); i++){
                idmedicines.add(medId.getLong(i));
            }
        }
        
        this.setName(jObj.getString("name"));
        this.setMedicineId(idmedicines);
        this.setSymptomId(idsymptoms);
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(List<Long> symptomId) {
        this.symptomId = symptomId;
    }

    public List<Long> getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(List<Long> medicineId) {
        this.medicineId = medicineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiseaseDto() {
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
}
