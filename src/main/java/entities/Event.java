package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "titolo", nullable = false)
    private String title;

    @Column(name = "data_evento", nullable = false)
    private LocalDate eventDate;

    @Column(name = "descrizione_evento", nullable = false)
    private String eventDescription;

    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "max_partecipanti", nullable = false)
    private int maxParticipants;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Event() {
    }

    public Event(String title, LocalDate eventDate, String eventDescription, EventType eventType, int maxParticipants, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
