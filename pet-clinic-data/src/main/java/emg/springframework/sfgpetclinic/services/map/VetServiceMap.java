package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
        return super.save(element);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

}
