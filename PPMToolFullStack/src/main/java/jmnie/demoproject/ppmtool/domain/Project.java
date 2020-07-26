package jmnie.demoproject.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message ="Project Name is Required." )
    private String projectName;
    @NotBlank(message ="Project Identifier is Required.")
    @Size(min=4, max=5, message="Please Use 4 to 5 Characters.")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message ="Project description is required.")
    private String description;
    @JsonFormat(pattern = "yy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yy-mm-dd")
    private Date end_date;
    @JsonFormat(pattern = "yy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yy-mm-dd")
    private Date updated_At;

    public Project(){

    }

    // setter and getter for project id
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    // setter for project name
    public String getProjectName(){
        return this.projectName;
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    // setter and getter for project identifier
    public String getProjectIdentifier(){
        return this.projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier){
        this.projectIdentifier = projectIdentifier;
    }

    //setter and getter for project description
    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    //setter for start_date and end date
    public Date getStart_date(){
        return this.start_date;
    }

    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }

    //setter and getter for end_date
    public Date getEnd_date(){
        return this.end_date;
    }

    public void setEnd_date(Date end_date){
        this.end_date = end_date;
    }

    public Date getCreated_At(){
        return this.created_At;
    }

    public void setCreated_At(Date created_At){
        this.created_At = created_At;
    }

    public Date getUpdated_At(){
        return this.updated_At;
    }

    public void setUpdated_At(Date updated_At){
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void onCreated(){
        this.created_At = new Date();

    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }


}
