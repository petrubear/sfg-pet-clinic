package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Pet;
import emg.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PerServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Pet element) {
		super.delete(element);
	}

	@Override
	public Pet save(Pet element) {
		return super.save(element);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

}
