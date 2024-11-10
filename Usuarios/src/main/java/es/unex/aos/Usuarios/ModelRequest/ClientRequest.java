package es.unex.aos.Usuarios.ModelRequest;

public class ClientRequest {
      private String userName;       // Nombre de usuario
      private String userPassword;   // Contraseña del usuario
      private String email;          // Correo electrónico del usuario
      private String tlfNumber;      // Número de teléfono del usuario (puede ser opcional o nulo)
  
      // Constructor
      public ClientRequest(String userName, String userPassword, String email, String tlfNumber) {
          this.userName = userName;
          this.userPassword = userPassword;
          this.email = email;
          this.tlfNumber = tlfNumber;
      }
  
      // Getters y Setters
      public String getUserName() {
          return userName;
      }
  
      public void setUserName(String userName) {
          this.userName = userName;
      }
  
      public String getUserPassword() {
          return userPassword;
      }
  
      public void setUserPassword(String userPassword) {
          this.userPassword = userPassword;
      }
  
      public String getEmail() {
          return email;
      }
  
      public void setEmail(String email) {
          this.email = email;
      }
  
      public String getTlfNumber() {
          return tlfNumber;
      }
  
      public void setTlfNumber(String tlfNumber) {
          this.tlfNumber = tlfNumber;
      }
  }
  