package emg.springframework.sfgpetclinic.bootstrap;

import emg.springframework.sfgpetclinic.model.*;
import emg.springframework.sfgpetclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, VetService vetService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        var count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        var dog = new PetType();
        dog.setName("Dog");
        var dogType = petTypeService.save(dog);
        var cat = new PetType();
        cat.setName("Cat");
        var catType = petTypeService.save(cat);

        var mike = new Owner();
        mike.setFirstName("Michael");
        mike.setLastName("Weston");
        mike.setAddress("123 BlaBla");
        mike.setCity("Miami");
        mike.setTelephone("00123444556");

        var mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(mike);
        mikesPet.setName("Rosco");
        mikesPet.setBirthday(LocalDate.now());
        mike.getPets().add(mikesPet);

        var fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glennane");
        fiona.setAddress("345 StoreStrt");
        fiona.setCity("Washington");
        fiona.setTelephone("00122442353");

        var fionasPet = new Pet();
        fionasPet.setPetType(cat);
        fionasPet.setOwner(fiona);
        fionasPet.setName("Fluffy");
        fionasPet.setBirthday(LocalDate.now());
        fiona.getPets().add(fionasPet);

        ownerService.save(mike);
        ownerService.save(fiona);

        logger.info("Loaded owners...");

        var catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        logger.info("Loaded visits...");

        var radiology = new Speciality();
        radiology.setDescription("Radiology");
        var savedRadiology = specialityService.save(radiology);
        var surgery = new Speciality();
        surgery.setDescription("Surgery");
        var savedSurgery = specialityService.save(surgery);
        var dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        var savedDentristry = specialityService.save(dentistry);

        var vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        vet1.getSpecialities().add(dentistry);

        var vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet1);
        vetService.save(vet2);

        logger.info("Loaded vets...");
    }
}
