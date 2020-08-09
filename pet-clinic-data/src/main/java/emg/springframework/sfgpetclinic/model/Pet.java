package emg.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_fate")
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL,
        mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
