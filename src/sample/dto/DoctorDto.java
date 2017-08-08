package sample.dto;

public class DoctorDto {
    /**
     * The id of the 'Doctor'
     */
    private Long id;
    
    /**
     * The firstName of the 'Doctor'
     */
    private String firstName;
    
    /**
     * The lastName of the 'Doctor'
     */
    private String lastName;
    
    /**
     * The address of the 'Doctor'
     */
    private String address;
    
    /**
     * The specialization of the 'Doctor'
     */
    private String specialization;
    
    /**
     * The contactNumber of the 'Doctor'
     */
    private String contactNumber;
    
    /**
     * The birthDay of the 'Doctor'
     */
    private String birthDay;
    
    /**
     * The userName of the 'Doctor'
     */
    private String userName;
    
    /**
     * The passWord of the 'Doctor'
     */
    private String passWord;
    
    /**
     * The Email of the 'Doctor'
     */
    private String email;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Creates an instance of 'Doctor'
     */
    public DoctorDto(){
        
    }
    
    /**
     * Creates an instance of 'Doctor' with attribute initialization
     */
    public DoctorDto(String firstName, String lastName, String address, String specialization,
            String contactNumber, String birthDay, String userName, String passWord, String email){
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setSpecialization(specialization);
        this.setContactNumber(contactNumber);
        this.setBirthDay(birthDay);
        this.setUserName(userName);
        this.setPassWord(passWord);
        this.setEmail(email);
    }
    
    /**
     * Retrieves the id of the 'Doctor'
     * @return the id of the 'Doctor'
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id of the 'Doctor'
     * @param id - the value to be set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retrieves the first name of the 'Doctor'.
     * @return the firstName of the 'Doctor'
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name of the 'Doctor'.
     * @param firstName - the value to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Retrieves the last name of the 'Doctor'.
     * @return the lastName of the 'Doctor'
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name of the 'Doctor'.
     * @param lastName - the value to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Retrieves the address of the 'Doctor'.
     * @return the address of the 'Doctor'
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the address of the 'Doctor'
     * @param address - the value to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Retrieves the specialization of the 'Doctor'.
     * @return the specialization of the 'Doctor'
     */
    public String getSpecialization() {
        return specialization;
    }
    
    /**
     * Sets the specialization of the 'Doctor'.
     * @param specialization - the value to be set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    /**
     * Retrieves the contact number of the 'Doctor'.
     * @return the contactNumber of the 'Doctor'
     */
    public String getContactNumber() {
        return contactNumber;
    }
    
    /**
     * Sets the contact number of the 'Doctor'.
     * @param contactNumber - the value to be set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    /**
     * Retrieves the birthday of the 'Doctor'.
     * @return the birthDay of the 'Doctor'
     */
    public String getBirthDay() {
        return birthDay;
    }
    
    /**
     * Sets the birthday of the 'Doctor'.
     * @param birthDay - the value to be set
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
    /**
     * Retrieves the username of the 'Doctor'.
     * @return the userName of the 'Doctor'
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Sets the username of the 'Doctor'.
     * @param userName - the value to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Retrieves the password of the 'Doctor'.
     * @return the passWord of the 'Doctor'
     */
    public String getPassWord() {
        return passWord;
    }
    
    /**
     * Sets the password of the 'Doctor'.
     * @param passWord - the value to be set=
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
