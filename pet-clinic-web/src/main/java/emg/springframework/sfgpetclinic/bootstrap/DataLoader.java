package emg.springframework.sfgpetclinic.bootstrap;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.model.PetType;
import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.OwnerService;
import emg.springframework.sfgpetclinic.services.PetTypeService;
import emg.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, VetService vetService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        var dog = new PetType();
        dog.setName("Dog");
        var dogType = petTypeService.save(dog);
        var cat = new PetType();
        cat.setName("Cat");
        var catType = petTypeService.save(cat);

        var owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        var owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("loaded owners...");

        var vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        var vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("loaded vets...");
    }

}
