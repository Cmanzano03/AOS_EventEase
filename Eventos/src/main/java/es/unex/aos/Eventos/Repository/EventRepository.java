package es.unex.aos.Eventos.Repository;

import es.unex.aos.Eventos.Model.Event;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EventRepository {
    private final List<Event> events = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public EventRepository() {
        // Inicializamos con algunos eventos predeterminados
        events.add(new Event(idCounter.getAndIncrement(), "Coldplay. Gira 2024", LocalDate.of(2024, 12, 7), "Roma", "Stadio Olimpico", 180.0, 1600.0, 2));
        events.add(new Event(idCounter.getAndIncrement(), "Bruce Springsteen. Gira 2025", LocalDate.of(2025, 6, 21), "San Sebastián", "Estadio Anoeta", 196.5, 1054.0, 3));
        events.add(new Event(idCounter.getAndIncrement(), "Iron Maiden. Gira 2025", LocalDate.of(2025, 7, 5), "Madrid", "Wanda Metropolitano", 122.02, 1500.0, 3));
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public Optional<Event> getEventById(Integer id) {
        return events.stream().filter(event -> event.getId().equals(id)).findFirst();
    }

    public Event addEvent(Event event) {
        event.setId(idCounter.getAndIncrement());
        events.add(event);
        return event;
    }

    public boolean deleteEvent(Integer id) {
        return events.removeIf(event -> event.getId().equals(id));
    }

    public Optional<Event> updateEvent(Integer id, Event updatedEvent) {
        Optional<Event> existingEvent = getEventById(id);
        existingEvent.ifPresent(event -> {
            event.setName(updatedEvent.getName());
            event.setDate(updatedEvent.getDate());
            event.setCity(updatedEvent.getCity());
            event.setAddress(updatedEvent.getAddress());
            event.setMinPrice(updatedEvent.getMinPrice());
            event.setMaxPrice(updatedEvent.getMaxPrice());
            event.setIdAdministrator(updatedEvent.getIdAdministrator());
        });
        return existingEvent;
    }
}

