package es.unex.aos.Eventos.Controllers;

import es.unex.aos.Eventos.Model.Event;
import es.unex.aos.Eventos.Model.EventRequest;
import es.unex.aos.Eventos.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventRepository.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // Obtener un evento por su id
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        Optional<Event> event = eventRepository.getEventById(id);
        return event.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest eventRequest) {
        Event newEvent = new Event(eventRequest); // Usamos el constructor de Event que recibe EventRequest
        eventRepository.addEvent(newEvent);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    // Actualizar un evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody EventRequest eventRequest) {
        Optional<Event> existingEvent = eventRepository.updateEvent(id, new Event(eventRequest));
        return existingEvent.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        boolean deleted = eventRepository.deleteEvent(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
