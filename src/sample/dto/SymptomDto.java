package sample.dto;

import org.slim3.repackaged.org.json.JSONObject;

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
    public SymptomDto(JSONObject obj) throws Exception{    
        this.setName(obj.getString("name"));
    }
    
    /**
     * Creates an instance of 'Symptom' with attribute initialization
     */
  
    
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
