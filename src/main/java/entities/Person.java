package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "cognome", nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate birthDate;

    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private Genres genre;

    @OneToMany(mappedBy = "person")
    private List<Participation> participations = new ArrayList<>();

    public Person() {

    }

    public Person(String name, String surname, String email, LocalDate birthDate, Genres genre) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.genre = genre;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", genre=" + genre +
                ", participations=" + participations +
                '}';
    }
}
