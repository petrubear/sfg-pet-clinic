package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Visit;
import emg.springframework.sfgpetclinic.repositories.VisitRepository;
import emg.springframework.sfgpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSpringJpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitSpringJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        var visits = new HashSet<Visit>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit element) {
        return visitRepository.save(element);
    }

    @Override
    public void delete(Visit element) {
        visitRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
