package emg.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudServices<T, ID> {

	Set<T> findAll();

	T findById(ID id);

	T save(T element);

	void delete(T element);

	void deleteById(ID id);

}
