package es.unex.aos.Usuarios.Model;

import es.unex.aos.Usuarios.ModelRequest.AdminRequest;

public class Admin extends User {
      private String vat;   // Identificador fiscal de la empresa (no nulo)
      private String iban;  // Cuenta de cargo (puede ser nulo)
      
      public Admin(String userName, String userPassword, String email, String tlfNumber, String vat, String iban) {
          super(userName,  userPassword,  email,  tlfNumber);
          this.vat = vat;
          this.iban = iban;
      }
  
      // Constructor que recibe un objeto AdminRequest
      public Admin(AdminRequest adminRequest) {
          super(adminRequest.getUserName(), adminRequest.getUserPassword(), adminRequest.getEmail(), adminRequest.getTlfNumber());
          this.vat = adminRequest.getVat();
          this.iban = adminRequest.getIban();
      }
  
      // Getters y Setters
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
      public void displayRole() {
          System.out.println("Rol: Administrador");
      }
  }
  