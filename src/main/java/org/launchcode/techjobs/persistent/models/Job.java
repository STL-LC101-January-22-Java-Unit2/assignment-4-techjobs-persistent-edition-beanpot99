package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;



    @ManyToMany
    @JoinTable(name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "skills_id"))
    private final List<Skill> skills = new ArrayList<>();





    public Job() {
    }

    public Job(Employer anEmployer) {
        super();
        this.employer = anEmployer;

    }

    // Getters and setters.



    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }
    public void addSkill(Skill skill){
        skills.add(skill);
    }
}
