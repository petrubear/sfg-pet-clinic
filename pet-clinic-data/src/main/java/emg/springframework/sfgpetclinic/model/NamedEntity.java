package emg.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

}
