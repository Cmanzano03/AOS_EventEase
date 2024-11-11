package es.unex.aos.Usuarios.Controllers;

import es.unex.aos.Usuarios.Model.User;
import es.unex.aos.Usuarios.Model.Client;
import es.unex.aos.Usuarios.Model.Admin;
import es.unex.aos.Usuarios.Repository.UsersRepository;
import es.unex.aos.Usuarios.ModelRequest.ClientRequest;
import es.unex.aos.Usuarios.ModelRequest.AdminRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users") // Base path for all user-related endpoints
public class UsersController {

      private final UsersRepository usersRepository;

      @Autowired
      public UsersController(UsersRepository usersRepository) {
            this.usersRepository = usersRepository;
      }

      // Obtener todos los usuarios
      @GetMapping
      public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = usersRepository.getAllUsers();
            return ResponseEntity.ok(users);
      }

      // Obtener un usuario por ID
      @GetMapping("/{id}")
      public ResponseEntity<User> getUserById(@PathVariable int id) {
            Optional<User> user = usersRepository.findById(id);
            return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
      }

      // Obtener un usuario por nombre de usuario
      @GetMapping("/username/{userName}")
      public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
            User user = usersRepository.findByUserName(userName);
            return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
      }

      // Crear un nuevo cliente
      @PostMapping("/client")
      public ResponseEntity<User> createClient(@RequestBody ClientRequest clientRequest) {
            String mensaje = clientRequest.toString();
            System.out.println("VALOR DE CLIENTREQUEST: " + mensaje);

            Client client = new Client(clientRequest);
            usersRepository.addUser(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
      }

      // Crear un nuevo administrador
      @PostMapping("/admin")
      public ResponseEntity<User> createAdmin(@RequestBody AdminRequest adminRequest) {

            System.out.println("VALOR DE ADMINREQUEST: " + adminRequest.toString());

            Admin admin = new Admin(adminRequest);
            usersRepository.addUser(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(admin);
      }

      @PutMapping("/client/{id}")
      public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client updatedClient) {
            boolean updated = usersRepository.updateUser(id, updatedClient);
            return updated ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
      }

      @PutMapping("/admin/{id}")
      public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin updatedAdmin) {
            boolean updated = usersRepository.updateUser(id, updatedAdmin);
            return updated ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
      }

      // Eliminar un usuario por ID
      @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteUser(@PathVariable int id) {

            boolean deleted = usersRepository.deleteUser(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
      }
}
