package es.unex.aos.Usuarios.Model;
import es.unex.aos.Usuarios.ModelRequest.ClientRequest;

public class Client extends User {

      // Constructor que recibe un objeto UsuarioRequest
      public Client(String userName, String userPassword, String email, String tlfNumber) {
          super(userName,  userPassword,  email,  tlfNumber);
      }
      public Client(ClientRequest clientRequest) {
          super(clientRequest.getUserName(), clientRequest.getUserPassword(), clientRequest.getEmail(), clientRequest.getTlfNumber());
          // El id será autogenerado y asignado cuando se guarde en el repositorio, por lo que no es necesario pasarlo en el constructor
      }
  
      @Override
      public void displayRole() {
          // Implementación del método abstracto para mostrar el rol del usuario
          System.out.println("Rol: Cliente");
      }
  }
  
