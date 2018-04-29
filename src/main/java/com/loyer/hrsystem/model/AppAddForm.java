package com.loyer.hrsystem.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Application ekleme formunun modeli.
 * Bu sınıfın görevi ihtiyacımız olan datayı viewdan alıp
 * service katmanına taşımak.
 */
public class AppAddForm {
    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String eMail;

    @NotNull
    private long phoneNumber;

    @NotEmpty
    private String address;

    @NotEmpty
    private String thoughtsJob;


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

    public String getThoughtsJob() {
        return thoughtsJob;
    }

    public void setThoughtsJob(String thoughtsJob) {
        this.thoughtsJob = thoughtsJob;
    }
}
