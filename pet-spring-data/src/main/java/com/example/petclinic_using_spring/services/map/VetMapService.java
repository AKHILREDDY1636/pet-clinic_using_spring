package com.example.petclinic_using_spring.services.map;

import com.example.petclinic_using_spring.models.Vet;
import com.example.petclinic_using_spring.services.CrudService;
import com.example.petclinic_using_spring.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}