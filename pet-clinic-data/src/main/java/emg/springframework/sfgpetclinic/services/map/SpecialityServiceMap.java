package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Speciality;
import emg.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile( {"default, map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
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
