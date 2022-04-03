package com.example.petclinic_using_spring.services;

import com.example.petclinic_using_spring.models.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lname);
}
