package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "partite_calcio")
@DiscriminatorValue("Calcio")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaCalcio p WHERE p.golSquadraCasa > p.golSquadraOspite")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaCalcio p WHERE p.golSquadraOspite > p.golSquadraCasa")
public class PartitaCalcio extends Event {
    @Column(name = "squadra_casa", nullable = false)
    private String squadraCasa;

    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "gol_squadra_casa", nullable = false)
    private int golSquadraCasa;

    @Column(name = "gol_squadra_ospite", nullable = false)
    private int golSquadraOspite;

    public PartitaCalcio() {
    }

    public PartitaCalcio(String title, LocalDate eventDate, String eventDescription, EventType eventType, int maxParticipants, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                "} " + super.toString();
    }
}
