package emg.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends NamedEntity {

    private PetType petType;

    private Person owner;

    private LocalDate birthday;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
