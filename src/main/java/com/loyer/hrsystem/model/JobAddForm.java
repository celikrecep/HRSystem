package com.loyer.hrsystem.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JobAddForm {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String jobTitle;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String description;

    @NotNull
    private int numbHirePeople;

    @NotEmpty
    private String lastAppDate;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
}
