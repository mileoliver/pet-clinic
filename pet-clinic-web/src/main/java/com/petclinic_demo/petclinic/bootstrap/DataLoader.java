package com.petclinic_demo.petclinic.bootstrap;

import com.petclinic_demo.petclinic.model.*;
import com.petclinic_demo.petclinic.model.services.OwnerService;
import com.petclinic_demo.petclinic.model.services.PetTypeService;
import com.petclinic_demo.petclinic.model.services.SpecialtyService;
import com.petclinic_demo.petclinic.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Specialty radiology=new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology=specialtyService.save(radiology);

        Specialty dentistry=new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry=specialtyService.save(dentistry);

        Specialty surgery=new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery=specialtyService.save(surgery);

        Owner owner1=new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Johnson");
        owner1.setAddress("Address of Owner1");
        owner1.setCity("Brasilia");
        owner1.setTelephone("+578236583");
        Pet owner1sFirstPet=new Pet();
        owner1sFirstPet.setOwner(owner1);
        owner1sFirstPet.setPetType(savedDogPetType);
        owner1sFirstPet.setName("Themistokles");
        owner1sFirstPet.setBirthDate(LocalDate.of(2020,04,14));
        owner1.getPets().add(owner1sFirstPet);

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Peter");
        owner2.setLastName("Petersen");
        owner2.setAddress("Address of Owner2");
        owner2.setCity("Tokyo");
        owner2.setTelephone("+2874363464");

        Pet owner2sFirstPet=new Pet();
        owner2sFirstPet.setOwner(owner2);
        owner2sFirstPet.setPetType(savedCatPetType);
        owner2sFirstPet.setName("Framboise");
        owner2sFirstPet.setBirthDate(LocalDate.of(2017,02,02));
        owner2.getPets().add(owner2sFirstPet);

        ownerService.save(owner2);

        System.out.println("Owners ok");

        Vet vet1=new Vet();
        vet1.setFirstName("Mary");
        vet1.setLastName("Deer");
        vet1.getSpecialties().add(savedSurgery);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Anne");
        vet2.setLastName("Karenina");
        vet2.getSpecialties().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Vets ok");
        System.out.println(Charset.defaultCharset().displayName());
    }
}
