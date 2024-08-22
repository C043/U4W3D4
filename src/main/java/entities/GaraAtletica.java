package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gare_atletica")
public class GaraAtletica extends Event {
    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Person vincitore;

    @ManyToMany
    @JoinTable(
            name = "atleti_gare",
            joinColumns = @JoinColumn(name = "gare_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    private Set<Person> atleti = new HashSet<>();

    public GaraAtletica() {
    }

    public GaraAtletica(String title, LocalDate eventDate, String eventDescription, EventType eventType, int maxParticipants, Location location, Person vincitore, Set<Person> atleti) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.vincitore = vincitore;
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    public Set<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Person> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraAtletica{" +
                "vincitore=" + vincitore.getSurname() +
                ", atleti=" + atleti +
                "} " + super.toString();
    }
}
