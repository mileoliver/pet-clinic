package com.petclinic_demo.petclinic.model.services;

import com.petclinic_demo.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
