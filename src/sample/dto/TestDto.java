package sample.dto;

import java.util.Date;
import java.util.List;

/***
 * Data transfer object for client-server operations.
 * @author Peter Guisadio
 *
 */
public class TestDto {
    private long id;
    private List<String> errorList;
    private String content;
    private String createdDate = new Date().toString();
    
    public List<String> getErrorList() {
        return errorList;
    }
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
