package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Pet;
import emg.springframework.sfgpetclinic.repositories.PetRepository;
import emg.springframework.sfgpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSpringJpaService implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetSpringJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        var pets = new HashSet<Pet>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet element) {
        return petRepository.save(element);
    }

    @Override
    public void delete(Pet element) {
        petRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
