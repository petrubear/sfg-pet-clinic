package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.services.CrudServices;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudServices<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner element) {
        super.delete(element);
    }

    @Override
    public Owner save(Owner element) {
        return super.save(element.getId(), element);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
