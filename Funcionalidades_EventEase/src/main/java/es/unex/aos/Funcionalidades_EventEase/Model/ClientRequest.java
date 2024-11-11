package es.unex.aos.Funcionalidades_EventEase.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ClientRequest implements Serializable {
      @JsonProperty("userName")
      private String userName;       // Nombre de usuario
      @JsonProperty("userPassword")
      private String userPassword;   // Contraseña del usuario
      @JsonProperty("email")
      private String email;          // Correo electrónico del usuario
      @JsonProperty("tlfNumber")
      private String tlfNumber;      // Número de teléfono del usuario (puede ser opcional o nulo)
  
      // Constructor
      public ClientRequest() {
            
      }
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

      @Override
      public String toString() {
            return "ClientRequest [userName=" + userName + ", userPassword=" + userPassword + ", email=" + email
                        + ", tlfNumber=" + tlfNumber + "]";
      }
  }
  