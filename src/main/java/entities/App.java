package entities;

import dao.EventsDAO;
import dao.LocationsDAO;
import dao.ParticipationDAO;
import dao.PersonDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);
        PersonDAO ped = new PersonDAO(em);


        System.out.println(pd.findById(UUID.fromString("a1cbfdd2-b13d-4ce8-b57a-dc9284b33f6e")).getPerson());

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
