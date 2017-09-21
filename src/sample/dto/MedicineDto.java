package sample.dto;

import java.util.Date;

import org.slim3.repackaged.org.json.JSONObject;

public class MedicineDto extends ErrorsDto{
    private Long id;
    private String name;
    //private String genericName;
    private String description;
    private Float price;
    private String type;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    
    public MedicineDto(){
        
    }
    
    public MedicineDto(JSONObject jObj) throws Exception{
        this.setName(jObj.getString("name"));
        //this.setGenericName(jObj.getString("genericName"));
        this.setDescription(jObj.getString("description"));
        this.setType(jObj.getString("type"));
        this.setPrice((float)jObj.getDouble("price"));
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    /*public String getGenericName() {
        return genericName;
    }
    
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }*/
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
}
