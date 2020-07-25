package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Vet;
import emg.springframework.sfgpetclinic.services.CrudServices;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudServices<Vet, Long> {
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
        return super.save(element.getId(), element);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
