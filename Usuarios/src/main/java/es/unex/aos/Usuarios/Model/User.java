package es.unex.aos.Usuarios.Model;



public abstract class User {
      private Integer id;           
      private String userName;      
      private String userPassword;  
      private String email;         
      private String tlfNumber;     

      // Constructor con todos los campos excepto el ID (que es autogenerado en el repositorio al insertarlos)
      public User(String userName, String userPassword, String email, String tlfNumber) {
          this.userName = userName;
          this.userPassword = userPassword;
          this.email = email;
          this.tlfNumber = tlfNumber;
      }
  
      // Getters y Setters
      public Integer getId() {
          return id;
      }
  
      public void setId(Integer id) {
          this.id = id;
      }
  
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
      
      // Método abstracto para cualquier comportamiento específico en subclases
      public abstract void displayRole();
  }
  