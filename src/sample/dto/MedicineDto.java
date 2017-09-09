package sample.dto;

public class MedicineDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    
    public MedicineDto(){
        
    }
    
    public MedicineDto(String name, String description, Double price){
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
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
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
