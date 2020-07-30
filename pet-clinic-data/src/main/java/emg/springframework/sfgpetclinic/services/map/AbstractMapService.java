package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T element) {
        if (element != null) {
            if (element.getId() == null) {
                element.setId(getNextId());
            }

            map.put(element.getId(), element);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return element;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T element) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(element));
    }

    private Long getNextId() {
        if (map.keySet().size() == 0) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1L;
    }
}
