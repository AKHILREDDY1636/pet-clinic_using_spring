package com.example.petclinic_using_spring.services.map;

import com.example.petclinic_using_spring.models.Speciality;
import com.example.petclinic_using_spring.models.Vet;
import com.example.petclinic_using_spring.services.CrudService;
import com.example.petclinic_using_spring.services.SpecialityService;
import com.example.petclinic_using_spring.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(Long.toString(speciality.getId()) == null || Long.toString(speciality.getId()).length()==0 ){
                    Speciality savedSpeciality=specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
