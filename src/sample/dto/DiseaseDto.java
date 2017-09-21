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
    private Date deletedAt;
    private Date updatedAt;
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
    public DiseaseDto (JSONObject jObj) throws Exception{
        this.setName(jObj.getString("diseasename"));
        //this.setGenericName(jObj.getString("genericName"));
        JSONArray sympId = jObj.getJSONArray("medicineids");
        JSONArray medId = jObj.getJSONArray("symptomsids");
        List<Long> idsymptoms = new ArrayList<Long>();
        List<Long> idmedicines = new ArrayList<Long>();
        for(int i=0;i<sympId.length();i++){
            idsymptoms.add(sympId.getJSONObject(i).getLong("id"));
            System.out.println("symp: " +sympId.getJSONObject(i).getLong("id"));
           
        }
        for(int i=0;i<medId.length();i++){
            idmedicines.add(medId.getJSONObject(i).getLong("id"));
        }
        this.setMedicineId(idmedicines);
        this.setSymptomId(idsymptoms);
        this.setUpdatedAt(new Date());
        this.setDeletedAt(null);
    }

    public DiseaseDto() {
        // TODO Auto-generated constructor stub
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
