package com.petclinic_demo.petclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{

    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.petclinic_demo.petclinic.model.Pet getPet() {
        return pet;
    }

    public void setPet(com.petclinic_demo.petclinic.model.Pet pet) {
        this.pet = pet;
    }
}
