package com.example.petclinic_using_spring.services.map;

import com.example.petclinic_using_spring.models.Owner;
import com.example.petclinic_using_spring.models.Pet;
import com.example.petclinic_using_spring.services.CrudService;
import com.example.petclinic_using_spring.services.OwnerService;
import com.example.petclinic_using_spring.services.PetService;
import com.example.petclinic_using_spring.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner=null;
        if(object!=null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(Long.toString(pet.getPetType().getId()) == null || Long.toString(pet.getPetType().getId()).length()==0 ){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(Long.toString(pet.getId())==null || Long.toString(pet.getId()).length()==0){
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lname) {
        return null;
    }
}
