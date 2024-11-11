package es.unex.aos.Funcionalidades_EventEase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.unex.aos.Funcionalidades_EventEase.Model.Admin;
import es.unex.aos.Funcionalidades_EventEase.Model.AdminRequest;
import es.unex.aos.Funcionalidades_EventEase.Model.Client;
import es.unex.aos.Funcionalidades_EventEase.Model.ClientRequest;
import es.unex.aos.Funcionalidades_EventEase.Model.Event;
import es.unex.aos.Funcionalidades_EventEase.Model.Ticket;
import es.unex.aos.Funcionalidades_EventEase.Model.TicketRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/central") // La URL base para todos los endpoints de tickets
public class centralController {

      private RestTemplate restTemplate;

      @Autowired
      public centralController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
      }

      // Metodo para crear un cliente
      @PostMapping("/crearClient")
      public ResponseEntity<Client> createClient(@RequestBody ClientRequest clientRequest) {
            String userServiceUrl = "http://Usuarios/users/client";
            return restTemplate.postForEntity(userServiceUrl, clientRequest, Client.class);
      }

      // Metodo para crear un admin
      @PostMapping("/crearAdmin")
      public ResponseEntity<Admin> createAdmin(@RequestBody AdminRequest adminRequest) {
            String userServiceUrl = "http://Usuarios/users/admin";
            return restTemplate.postForEntity(userServiceUrl, adminRequest, Admin.class);
      }

      // Metodo para eliminar un usuario dado su id
      @DeleteMapping("/eliminarUsuario/{id}")
      public ResponseEntity<Void> deleteClient(@PathVariable String id) {
            String userServiceUrl = "http://Usuarios/users/" + id;
            restTemplate.delete(userServiceUrl);
            return ResponseEntity.noContent().build();
      }

      // Metodo para consultar un evento dado su id
      @GetMapping("/getEvento")
      public ResponseEntity<Event> getEvento(@RequestParam String id) {
            String userServiceUrl = "http://Eventos/events/" + id;
            return restTemplate.getForEntity(userServiceUrl, Event.class);
      }

      //Metodo para consultar todos los eventos
      @GetMapping("/getEventos")
      public ResponseEntity<Event[]> getEventos() {
            String userServiceUrl = "http://Eventos/events";
            return restTemplate.getForEntity(userServiceUrl, Event[].class);
      }

      //Metodo para comprar un ticket
      @PostMapping("/comprarTicket")
      public ResponseEntity<Ticket> comprarTicket(@RequestBody TicketRequest ticketRequest) {
            String userServiceUrl = "http://Tickets/tickets";
            return restTemplate.postForEntity(userServiceUrl, ticketRequest, Ticket.class);
      }

      

}
