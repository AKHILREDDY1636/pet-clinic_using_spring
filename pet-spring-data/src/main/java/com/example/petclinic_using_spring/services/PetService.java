package com.example.petclinic_using_spring.services;

import com.example.petclinic_using_spring.models.Pet;


import java.util.Set;

public interface PetService {
    Pet findById(long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
