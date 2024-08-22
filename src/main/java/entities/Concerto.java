package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Event {
    @Column(name = "genere", nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneriMusicali genere;

    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String title, LocalDate eventDate, String eventDescription, EventType eventType, int maxParticipants, Location location, GeneriMusicali genere, boolean inStreaming) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GeneriMusicali getGenere() {
        return genere;
    }

    public void setGenere(GeneriMusicali genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
