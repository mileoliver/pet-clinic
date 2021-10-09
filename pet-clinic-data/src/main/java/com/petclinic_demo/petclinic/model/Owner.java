package com.petclinic_demo.petclinic.model;

import java.util.Set;

public class Owner extends Person{

    private Set<Pet> pets;

    public Set<com.petclinic_demo.petclinic.model.Pet> getPets() {
        return pets;
    }

    public void setPets(Set<com.petclinic_demo.petclinic.model.Pet> pets) {
        this.pets = pets;
    }
}
