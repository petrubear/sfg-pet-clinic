package emg.springframework.sfgpetclinic.services;

import emg.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudServices<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
