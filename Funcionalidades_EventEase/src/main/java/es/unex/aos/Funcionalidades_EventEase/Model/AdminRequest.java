package es.unex.aos.Funcionalidades_EventEase.Model;

public class AdminRequest {
      private String userName;       // Nombre de usuario
      private String userPassword;   // Contraseña del usuario
      private String email;          // Correo electrónico del usuario
      private String tlfNumber;      // Número de teléfono del usuario (puede ser nulo)
      private String vat;            // Identificador fiscal de la empresa (no nulo)
      private String iban;           // Cuenta de cargo (puede ser nulo)
  
      // Constructor

      public AdminRequest() {
      
      }
      
      public AdminRequest(String userName, String userPassword, String email, String tlfNumber, String vat, String iban) {
          this.userName = userName;
          this.userPassword = userPassword;
          this.email = email;
          this.tlfNumber = tlfNumber;
          this.vat = vat;
          this.iban = iban;
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
  
      public String getVat() {
          return vat;
      }
  
      public void setVat(String vat) {
          this.vat = vat;
      }
  
      public String getIban() {
          return iban;
      }
  
      public void setIban(String iban) {
          this.iban = iban;
      }

      @Override
      public String toString() {
            return "AdminRequest [userName=" + userName + ", userPassword=" + userPassword + ", email=" + email
                        + ", tlfNumber=" + tlfNumber + ", vat=" + vat + ", iban=" + iban + "]";
      }

      
  }
  