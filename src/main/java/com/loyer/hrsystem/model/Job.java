package com.loyer.hrsystem.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty
    @Size(min = 5, max = 100)
    @Column(name = "desc", nullable = false)
    private String description;

    @NotNull
    @Column(name = "numbPeople", nullable = false)
    private int numbHirePeople;

    @NotEmpty
    @Column(name = "appDate", nullable = false)
    private String lastAppDate;

    @OneToMany(mappedBy = "job")
    private Set<App> apps;


    public Job(){

    }
    public Job(String title, String description, int numbHirePeople, String lastAppDate){
        this.title = title;
        this.description = description;
        this.numbHirePeople = numbHirePeople;
        this.lastAppDate = lastAppDate;

    }


    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumbHirePeople() {
        return numbHirePeople;
    }

    public void setNumbHirePeople(int numbHirePeople) {
        this.numbHirePeople = numbHirePeople;
    }

    public String getLastAppDate() {
        return lastAppDate;
    }

    public void setLastAppDate(String lastAppDate) {
        this.lastAppDate = lastAppDate;
    }

    public Set<App> getApps() {
        return apps;
    }

    public void setApps(Set<App> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", desc='" + description + '\'' +
                ", numbPeople='" + numbHirePeople + '\'' +
                ", lastApp='" + lastAppDate + '\'' +
                '}';
    }
}
