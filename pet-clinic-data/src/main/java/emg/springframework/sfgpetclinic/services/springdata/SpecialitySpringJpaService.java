package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Speciality;
import emg.springframework.sfgpetclinic.repositories.SpecialityRepository;
import emg.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySpringJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialitySpringJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        var specialities = new HashSet<Speciality>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality element) {
        return specialityRepository.save(element);
    }

    @Override
    public void delete(Speciality element) {
        specialityRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
