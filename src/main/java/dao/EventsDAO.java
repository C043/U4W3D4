package dao;

import entities.Event;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventsDAO {
    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(event);

        transaction.commit();

        System.out.println("L'evento " + event.getTitle() + " è stato aggiunto con successo!");
    }

    public Event getEventById(UUID eventId) {
        Event found = em.find(Event.class, eventId);

        if (found == null) throw new NotFoundException(eventId);

        return found;
    }

    public void deleteEvent(UUID eventId) {
        Event found = getEventById(eventId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Evento " + found.getTitle() + " eliminato con successo.");
    }
}
