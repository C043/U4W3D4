package entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Participation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Event event;

    @Column(name = "stato_conferma")
    @Enumerated(EnumType.STRING)
    private ParticipationState state;

    public Participation() {

    }

    public Participation(Person person, Event event, ParticipationState state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipationState getState() {
        return state;
    }

    public void setState(ParticipationState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", person=" + person.getName() + " " + person.getSurname() +
                ", event=" + event.getTitle() +
                ", state=" + state +
                '}';
    }
}
