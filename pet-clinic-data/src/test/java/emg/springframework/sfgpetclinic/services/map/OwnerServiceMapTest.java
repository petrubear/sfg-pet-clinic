package emg.springframework.sfgpetclinic.services.map;

import emg.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        var owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName("Edison");
        owner.setLastName("Martinez");
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        var owners = ownerServiceMap.findAll();
        assertThat(owners.size()).isEqualTo(1);
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertThat(ownerServiceMap.findAll().size()).isEqualTo(0);
    }

    @Test
    void save() {
        Long id = 2L;
        var anotherOwner = new Owner();
        anotherOwner.setId(id);
        var savedOwner = ownerServiceMap.save(anotherOwner);

        assertThat(savedOwner.getId()).isEqualTo(id);
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertThat(ownerServiceMap.findAll().size()).isEqualTo(0);
    }

    @Test
    void findById() {
        var owner = ownerServiceMap.findById(ownerId);
        assertThat(owner.getId()).isEqualTo(ownerId);
    }

    @Test
    void findByLastName() {
        var owner = ownerServiceMap.findByLastName("Martinez");
        assertThat(owner.getId()).isEqualTo(ownerId);
    }
}