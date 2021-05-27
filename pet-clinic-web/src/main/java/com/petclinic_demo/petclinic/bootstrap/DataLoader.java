package com.petclinic_demo.petclinic.bootstrap;

import com.petclinic_demo.petclinic.model.Owner;
import com.petclinic_demo.petclinic.model.Vet;
import com.petclinic_demo.petclinic.model.services.OwnerService;
import com.petclinic_demo.petclinic.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Johnson");

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Peter");
        owner2.setLastName("Petersen");

        ownerService.save(owner2);

        System.out.println("Owners ok");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mary");
        vet1.setLastName("Deer");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Anne");
        vet2.setLastName("Karenina");

        vetService.save(vet2);

        System.out.println("Vets ok");

    }
}
