package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.repositories.OwnerRepository;
import emg.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSpringJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerSpringJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner element) {
        return ownerRepository.save(element);
    }

    @Override
    public void delete(Owner element) {
        ownerRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
