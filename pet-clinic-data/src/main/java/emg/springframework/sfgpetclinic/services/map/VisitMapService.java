package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Visit;
import emg.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit element) {
        super.delete(element);
    }

    @Override
    public Visit save(Visit element) {
        if (element == null || element.getPet() == null || element.getPet().getId() == null ||
            element.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(element);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
