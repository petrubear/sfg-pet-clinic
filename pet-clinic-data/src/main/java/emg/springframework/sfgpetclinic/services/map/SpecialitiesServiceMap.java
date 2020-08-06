package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Speciality;
import emg.springframework.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality element) {
        super.delete(element);
    }

    @Override
    public Speciality save(Speciality element) {
        return super.save(element);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
