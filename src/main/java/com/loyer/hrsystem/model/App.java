package com.loyer.hrsystem.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @Size(min = 1, max = 30)
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 100)
    @Email
    @Column(name = "email", nullable = false)
    private String eMail;

    @NotNull
    @Column(name = "phoneNumber", nullable = false)
    private long  phoneNumber;

    @NotEmpty
    @Column(name = "address", nullable = false)
    private String address;

    @NotEmpty
    @Size(min = 3, max = 100)
    @Column(name = "thoughtsJob", nullable = false)
    private String thoughtsOnJob;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public App() {

    }
    public App(String name, String eMail, long phoneNumber, String address, String thoughtsOnJob) {
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.thoughtsOnJob = thoughtsOnJob;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThoughtsOnJob() {
        return thoughtsOnJob;
    }

    public void setThoughtsOnJob(String thoughtsOnJob) {
        this.thoughtsOnJob = thoughtsOnJob;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + eMail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", thoughtsJob='" + thoughtsOnJob + '\'' +
                '}';
    }

}
