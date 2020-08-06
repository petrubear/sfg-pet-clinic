package emg.springframework.sfgpetclinic.bootstrap;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.model.Pet;
import emg.springframework.sfgpetclinic.model.PetType;
import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.OwnerService;
import emg.springframework.sfgpetclinic.services.PetTypeService;
import emg.springframework.sfgpetclinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

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
        owner1.setAddress("123 BlaBla");
        owner1.setCity("Miami");
        owner1.setTelephone("00123444556");

        var mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        mikesPet.setBirthday(LocalDate.now());

        var owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("345 StoreStrt");
        owner2.setCity("Washington");
        owner2.setTelephone("00122442353");

        var fionasPet = new Pet();
        fionasPet.setPetType(cat);
        fionasPet.setOwner(owner2);
        fionasPet.setName("Fluffy");
        fionasPet.setBirthday(LocalDate.now());

        ownerService.save(owner1);
        ownerService.save(owner2);

        logger.info("Loaded owners...");


        var vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        var vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);

        logger.info("Loaded vets...");
    }

}
