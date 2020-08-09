package emg.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {
}
