package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.repositories.VetRepository;
import emg.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpringJpaService implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetSpringJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet element) {
        return vetRepository.save(element);
    }

    @Override
    public void delete(Vet element) {
        vetRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
