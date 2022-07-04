package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
@Size(max=500,message="500 character maximum")
@NotBlank
    private String description;



    @ManyToMany(mappedBy="skills")
    @NotNull
private List<Job> jobs = new ArrayList<>();
    public Skill(String description, List aJob) {
        this.description = description;
        this.jobs = aJob;
    }
    public Skill(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }
//    public void addJob(Job job){
//        this.jobs.add(job);
//    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}