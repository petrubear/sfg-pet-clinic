package emg.springframework.sfgpetclinic.services.springdata;

import emg.springframework.sfgpetclinic.model.Owner;
import emg.springframework.sfgpetclinic.repositories.OwnerRepository;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringJpaServiceTest {

    @InjectMocks
    OwnerSpringJpaService ownerService;

    @Mock
    OwnerRepository ownerRepository;

    Owner defaultOwner;
    HashSet<Owner> owners;
    Long defaultOwnerId = 1L;
    String defaultName = "John";
    String defaultLastName = "Smith";

    @BeforeEach
    void setUp() {
        defaultOwner = new Owner();
        owners = new HashSet<>();
        defaultOwner.setId(defaultOwnerId);
        defaultOwner.setFirstName(defaultName);
        defaultOwner.setLastName(defaultLastName);
        owners.add(defaultOwner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(defaultOwner));
        Owner smith = ownerService.findByLastName(defaultLastName);
        assertThat(smith.getFirstName()).isEqualTo(defaultName);
        verify(ownerRepository, times(1)).findByLastName(anyString());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);
        val all = ownerService.findAll();
        assertThat(all.size()).isEqualTo(1);
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(defaultOwner));
        val owner = ownerService.findById(defaultOwnerId);
        assertThat(owner.getFirstName()).isEqualTo(defaultName);
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        val owner = new Owner();
        owner.setId(2L);
        val savedOwner = ownerService.save(owner);
        assertThat(savedOwner).isNotNull();
    }

    @Test
    void delete() {
        ownerService.delete(defaultOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(0L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}