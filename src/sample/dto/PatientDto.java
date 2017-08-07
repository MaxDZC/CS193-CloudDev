package sample.dto;

public class PatientDto {
    /**
     * The id of the 'Patient'
     */
    private Long id;
    
    /**
     * The firstName of the 'Patient'
     */
    private String firstName;
    
    /**
     * The lastName of the 'Patient'
     */
    private String lastName;
    
    /**
     * The address of the 'Patient'
     */
    private String address;
    
    /**
     * The specialization of the 'Patient'
     */
    private String specialization;
    
    /**
     * The contactNumber of the 'Patient'
     */
    private String contactNumber;
    
    /**
     * The birthDay of the 'Patient'
     */
    private String birthDay;
    
    /**
     * The userName of the 'Patient'
     */
    private String userName;
    
    /**
     * The passWord of the 'Patient'
     */
    private String passWord;
    
    /**
     * Creates an instance of 'Patient'
     */
    public PatientDto(){
        
    }
    
    /**
     * Creates an instance of 'Patient' with attribute initialization
     */
    public PatientDto(String firstName, String lastName, String address, String specialization,
            String contactNumber, String birthDay, String userName, String passWord){
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setSpecialization(specialization);
        this.setContactNumber(contactNumber);
        this.setBirthDay(birthDay);
        this.setUserName(userName);
        this.setPassWord(passWord);
    }
    
    /**
     * Retrieves the id of the 'Patient'
     * @return the id of the 'Patient'
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id of the 'Patient'
     * @param id - the value to be set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retrieves the first name of the 'Patient'.
     * @return the firstName of the 'Patient'
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name of the 'Patient'.
     * @param firstName - the value to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Retrieves the last name of the 'Patient'.
     * @return the lastName of the 'Patient'
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name of the 'Patient'.
     * @param lastName - the value to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Retrieves the address of the 'Patient'.
     * @return the address of the 'Patient'
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the address of the 'Patient'
     * @param address - the value to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Retrieves the specialization of the 'Patient'.
     * @return the specialization of the 'Patient'
     */
    public String getSpecialization() {
        return specialization;
    }
    
    /**
     * Sets the specialization of the 'Patient'.
     * @param specialization - the value to be set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    /**
     * Retrieves the contact number of the 'Patient'.
     * @return the contactNumber of the 'Patient'
     */
    public String getContactNumber() {
        return contactNumber;
    }
    
    /**
     * Sets the contact number of the 'Patient'.
     * @param contactNumber - the value to be set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    /**
     * Retrieves the birthday of the 'Patient'.
     * @return the birthDay of the 'Patient'
     */
    public String getBirthDay() {
        return birthDay;
    }
    
    /**
     * Sets the birthday of the 'Patient'.
     * @param birthDay - the value to be set
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
    /**
     * Retrieves the username of the 'Patient'.
     * @return the userName of the 'Patient'
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Sets the username of the 'Patient'.
     * @param userName - the value to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Retrieves the password of the 'Patient'.
     * @return the passWord of the 'Patient'
     */
    public String getPassWord() {
        return passWord;
    }
    
    /**
     * Sets the password of the 'Patient'.
     * @param passWord - the value to be set=
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
