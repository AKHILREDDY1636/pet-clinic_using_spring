package com.example.petclinic_using_spring.services;

import com.example.petclinic_using_spring.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
