package com.example.petclinic_using_spring.bootstrap;

import com.example.petclinic_using_spring.models.*;
import com.example.petclinic_using_spring.services.OwnerService;
import com.example.petclinic_using_spring.services.PetTypeService;
import com.example.petclinic_using_spring.services.SpecialityService;
import com.example.petclinic_using_spring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int petsCount=petTypeService.findAll().size();
        if(petsCount==0){
            loadData();
            petsCount=petTypeService.findAll().size();
        }
        for(PetType i:petTypeService.findAll()){
            System.out.println(i.getName());
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("dog");
        PetType savedDog=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("cat");
        PetType savedCat=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery=specialityService.save(surgery);

        Speciality dentist=new Speciality();
        dentist.setDescription("Dentist");
        Speciality savedDentist=specialityService.save(dentist);

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Akhil");
        owner1.setLastName("Reddy");
        owner1.setAddress("Hno.1-26");
        owner1.setCity("Dhandepalli");
        owner1.setTelephone("8790168626");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setOwner(owner1);
        mikesPet.setName("Dog");
        owner1.getPets().add(mikesPet);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ramya");
        owner2.setLastName("Reddy");
        owner2.setAddress("Hno.1-26");
        owner2.setCity("Dhandepalli");
        owner2.setTelephone("8790168626");

        Pet jackPet=new Pet();
        jackPet.setPetType(savedCat);
        jackPet.setBirthdate(LocalDate.now());
        jackPet.setOwner(owner2);
        jackPet.setName("Cat1");
        owner2.getPets().add(jackPet);

        Owner owner3=new Owner();
        owner3.setId(3L);
        owner3.setFirstName("HimaVarsha");
        owner3.setLastName("Reddy");
        owner3.setAddress("Hno.1-26");
        owner3.setCity("Dhandepalli");
        owner3.setTelephone("8790168626");

        Pet sonPet=new Pet();
        sonPet.setPetType(savedCat);
        sonPet.setBirthdate(LocalDate.now());
        sonPet.setOwner(owner3);
        sonPet.setName("Cat2");
        owner3.getPets().add(sonPet);

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        System.out.println("Loaded Owners ... !!! ");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ramya");
        vet1.setLastName("Reddy");
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Himavarsha");
        vet2.setLastName("Reddy");
        vet2.getSpecialities().add(savedDentist);

        Vet vet3=new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Akhil");
        vet3.setLastName("Reddy");
        vet3.getSpecialities().add(savedSurgery);

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Loaded vets ... !!!");
    }
}
