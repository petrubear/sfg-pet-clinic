package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.PetType;
import emg.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile( {"default, map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType element) {
        super.delete(element);
    }

    @Override
    public PetType save(PetType element) {
        return super.save(element);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
