package sample.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import sample.dto.DiseaseDto;

@Model(schemaVersion = 1)
public class DiseaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private Long id;
    private String name;
    private List<Long> symptomId;
    private List<Long> medicineId;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;

    public DiseaseModel(){}
    
    public DiseaseModel(DiseaseDto diseaseDto){
        this.setName(diseaseDto.getName().toLowerCase());
        this.setSymptomId(diseaseDto.getSymptomId());
        this.setMedicineId(diseaseDto.getMedicineId());
        this.setCreatedAt(diseaseDto.getCreatedAt());
        this.setUpdatedAt(diseaseDto.getUpdatedAt());
        this.setDeletedAt(diseaseDto.getDeletedAt());
    }
    
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Key getKey() {
        return key;
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

    public void setKey(Key key) {
        this.key = key;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDeletedAt() {
        return deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DiseaseModel other = (DiseaseModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

}
