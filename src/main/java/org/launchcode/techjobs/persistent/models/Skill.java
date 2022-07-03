package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
@Size(max=500,message="500 character maximum")
@NotEmpty
    private String description;

@ManyToMany(mappedBy="skills")
private final List<Job> jobs = new ArrayList<>();
    public Skill(String description) {
        this.description = description;
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
    public void addJob(Job job){
        this.jobs.add(job);
    }
}