package entities;

import dao.EventsDAO;
import dao.LocationsDAO;
import dao.ParticipationDAO;
import dao.PersonDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);
        PersonDAO ped = new PersonDAO(em);

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
