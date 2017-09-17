package sample.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;

public class DiseaseDto extends ErrorsDto {
    private Long id;
    private String name;
    private List<Long> symptomId;
    private List<Long> medicineId;
   
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
}
