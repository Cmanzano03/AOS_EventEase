package es.unex.aos.Tickets.Repository;

import es.unex.aos.Tickets.Model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TicketRepository {

      private final Map<Integer, Ticket> ticketMap;
      private final AtomicInteger nextId; // Contador atómico para el ID autogenerado

      // Constructor que inicializa el repositorio con datos de ejemplo
      public TicketRepository() {
            ticketMap = new ConcurrentHashMap<>(); // Usamos un ConcurrentHashMap para acceso concurrente seguro
            nextId = new AtomicInteger(1); // Inicializamos el contador en 1

            // Crear algunos tickets de ejemplo
            Ticket ticket1 = new Ticket(1, "VIP", 100.0, java.time.LocalDateTime.now());
            Ticket ticket2 = new Ticket(2, "General", 50.0, java.time.LocalDateTime.now());
            Ticket ticket3 = new Ticket(3, "VIP", 120.0, java.time.LocalDateTime.now());

            // Los añadimos al mapa
            addTicket(ticket1);
            addTicket(ticket2);
            addTicket(ticket3);
      }

      // Método para obtener todos los tickets
      public List<Ticket> getAllTickets() {
            return new ArrayList<Ticket>(ticketMap.values()); // Devolvemos una copia para evitar modificaciones externas
      }

      // Método para agregar un ticket al repositorio
      public Ticket addTicket(Ticket ticket) {
            int id = nextId.getAndIncrement(); // Obtenemos el siguiente ID autogenerado
            ticket.setId(id); // Asignamos el ID al ticket
            ticketMap.put(id, ticket); // Añadimos el ticket al mapa
            return ticket; // Retornamos el ticket con el ID asignado
      }

      // Método para encontrar un ticket por su ID
      public Optional<Ticket> findById(int id) {
            return Optional.ofNullable(ticketMap.get(id)); // Retorna el ticket si existe, si no, Optional.empty()
      }

      // Método para actualizar un ticket existente
      public boolean updateTicket(int id, Ticket updatedTicket) {
            if (ticketMap.containsKey(id)) {
                  updatedTicket.setId(id); // Mantenemos el ID original
                  ticketMap.put(id, updatedTicket); // Actualizamos el ticket en el mapa
                  return true;
            }
            return false;
      }

      // Método para eliminar un ticket por su ID
      public boolean deleteTicket(int id) {
            if (ticketMap.containsKey(id)) {
                  ticketMap.remove(id); // Eliminamos el ticket del mapa
                  return true;
            }
            return false;
      }
}
