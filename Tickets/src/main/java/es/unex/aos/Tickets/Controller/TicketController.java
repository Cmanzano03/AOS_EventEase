package es.unex.aos.Tickets.Controller;

import es.unex.aos.Tickets.Model.Ticket;
import es.unex.aos.Tickets.Model.TicketRequest;
import es.unex.aos.Tickets.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets") // La URL base para todos los endpoints de tickets
public class TicketController {

      private final TicketRepository ticketRepository;

      @Autowired
      public TicketController(TicketRepository ticketRepository) {
            this.ticketRepository = ticketRepository;
      }

      // Obtener todos los tickets
      @GetMapping
      public ResponseEntity<List<Ticket>> getAllTickets() {
            List<Ticket> tickets = ticketRepository.getAllTickets();
            return new ResponseEntity<>(tickets, HttpStatus.OK); // Retorna una lista de todos los tickets
      }

      // Obtener un ticket por ID
      @GetMapping("/{id}")
      public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
            Optional<Ticket> ticket = ticketRepository.findById(id);
            if (ticket.isPresent()) {
                  return new ResponseEntity<>(ticket.get(), HttpStatus.OK); // Retorna el ticket si lo encuentra
            } else {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el ticket
            }
      }

      // Crear un nuevo ticket
      @PostMapping
      public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequest ticketRequest){
            Ticket ticket = new Ticket(ticketRequest);
            ticketRepository.addTicket(ticket); // Añadimos el ticket al repositorio
            return new ResponseEntity<>(ticket, HttpStatus.CREATED); // Retorna el ticket creado con código 201
      }

      // Actualizar un ticket existente
      @PutMapping("/{id}")
      public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket updatedTicket) {
            boolean updated = ticketRepository.updateTicket(id, updatedTicket);
            if (updated) {
                  return new ResponseEntity<>(updatedTicket, HttpStatus.OK); // Retorna el ticket actualizado
            } else {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el ticket
            }
      }

      // Eliminar un ticket por ID
      @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
            boolean deleted = ticketRepository.deleteTicket(id);
            if (deleted) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si se eliminó correctamente
            } else {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el ticket
            }
      }
}
