package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.SpecialityService;
import emg.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    @Autowired
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet element) {
        super.delete(element);
    }

    @Override
    public Vet save(Vet element) {
        if (!element.getSpecialities().isEmpty()) {
            element.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    var savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(element);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

}
