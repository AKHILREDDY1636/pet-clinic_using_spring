package com.example.petclinic_using_spring.services;

import com.example.petclinic_using_spring.models.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lname);
    Owner findById(long id);
    Owner save(Owner owner);
        Set<Owner> findAll();
}
