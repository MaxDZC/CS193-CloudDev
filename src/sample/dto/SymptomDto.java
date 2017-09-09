package sample.dto;

public class SymptomDto {
    /**
     * The id of the 'Symptom'
     */
    private Long id;
    
    /**
     * The firstName of the 'Symptom'
     */
    private String name;
    
    
    
    
    
    /**
     * Creates an instance of 'Symptom'
     */
    public SymptomDto(){
        
    }
    
    /**
     * Creates an instance of 'Symptom' with attribute initialization
     */
    public SymptomDto(String name){
        
        this.setName(name);
      
    }
    
    /**
     * Retrieves the id of the 'Symptom'
     * @return the id of the 'Symptom'
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id of the 'Symptom'
     * @param id - the value to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
