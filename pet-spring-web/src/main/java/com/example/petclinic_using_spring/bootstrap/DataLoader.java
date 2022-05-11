package com.example.petclinic_using_spring.bootstrap;

import com.example.petclinic_using_spring.models.Owner;
import com.example.petclinic_using_spring.models.PetType;
import com.example.petclinic_using_spring.models.Vet;
import com.example.petclinic_using_spring.services.OwnerService;
import com.example.petclinic_using_spring.services.PetTypeService;
import com.example.petclinic_using_spring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog=new PetType();
        dog.setName("dog");
        PetType savedDog=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("dog");
        PetType savedCat=petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Akhil");
        owner1.setLastName("Reddy");

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ramya");
        owner2.setLastName("Reddy");

        Owner owner3=new Owner();
        owner3.setId(3L);
        owner3.setFirstName("HimaVarsha");
        owner3.setLastName("Reddy");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        System.out.println("Loaded Owners ... !!! ");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ramya");
        vet1.setLastName("Reddy");

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Himavarsha");
        vet2.setLastName("Reddy");

        Vet vet3=new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Akhil");
        vet3.setLastName("Reddy");

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Loaded vets ... !!!");

    }
}
