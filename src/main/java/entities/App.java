package entities;

import dao.EventsDAO;
import dao.LocationsDAO;
import dao.ParticipationDAO;
import dao.PersonDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);
        PersonDAO ped = new PersonDAO(em);

        /* ed.getEventiSoldOut().forEach(System.out::println);*/

        Location stadio = new Location("Stadio", "Milano");
        Person aldo = new Person("Aldo", "Baglio", "aldo.baglio@gmail.com", LocalDate.of(1990, 3, 4), Genres.MASCHIO);
        ld.save(stadio);
        Event concerto = new Concerto("Nitro", LocalDate.now(), "Una bomba", EventType.PUBBLICO, 1, stadio, GeneriMusicali.ROCK, false);
        ed.save(concerto);
        ped.save(aldo);
        pd.save(new Participation(aldo, concerto, ParticipationState.CONFERMATA));

        /*try {
            System.out.println(ed.getEventById(poveroPiero.getId()));
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            ed.deleteEvent(poveroPiero.getId());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        em.close();
        emf.close();
    }
}
