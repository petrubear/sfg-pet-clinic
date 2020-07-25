package emg.springframework.sfgpetclinic.services;

import emg.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudServices<Owner, Long> {

    Owner findByLastName(String lastName);
}
