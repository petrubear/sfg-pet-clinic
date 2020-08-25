package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.services.OwnerService;
import emg.springframework.sfgpetclinic.services.PetService;
import emg.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile( {"default, map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner element) {
        super.delete(element);
    }

    @Override
    public Owner save(Owner element) {

        if (element != null) {
            if (element.getPets() != null) {
                element.getPets().forEach(pet -> {
                    if (pet.getPetType() == null) {
                        throw new RuntimeException("PetType is mandatory");
                    }
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }

                    if (pet.getId() == null) {
                        var savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(element);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(o -> o.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }

}
