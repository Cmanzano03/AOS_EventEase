package es.unex.aos.Eventos.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Event {

      private Integer id;
      private String name;

      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
      private LocalDate date; 

      private String city;
      private String address;
      private Double minPrice;
      private Double maxPrice;
      private Integer idAdministrator;

       // Constructor, getters y setters
      public Event() {

      }
     
      //No añadimos el id por que haremos que sea autoincremental en el repositorio
      public Event(Integer id, String name, LocalDate date, String city, String address,
                  Double minPrice, Double maxPrice, Integer idAdministrator) {
                        
            this.id = id;
            this.name = name;
            this.date = date;
            this.city = city;
            this.address = address;
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
            this.idAdministrator = idAdministrator;
      }
      //No añadimos el id por que haremos que sea autoincremental en el repositorio
      public Event(EventRequest eventRequest) {
            this.name = eventRequest.getName();
            this.date = eventRequest.getDate();
            this.city = eventRequest.getCity();
            this.address = eventRequest.getAddress();
            this.minPrice = eventRequest.getMinPrice();
            this.maxPrice = eventRequest.getMaxPrice();
            this.idAdministrator = eventRequest.getIdAdministrator();
      }

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public LocalDate getDate() {
            return date;
      }

      public void setDate(LocalDate date) {
            this.date = date;
      }

      public String getCity() {
            return city;
      }

      public void setCity(String city) {
            this.city = city;
      }

      public String getAddress() {
            return address;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public Double getMinPrice() {
            return minPrice;
      }

      public void setMinPrice(Double minPrice) {
            this.minPrice = minPrice;
      }

      public Double getMaxPrice() {
            return maxPrice;
      }

      public void setMaxPrice(Double maxPrice) {
            this.maxPrice = maxPrice;
      }

      public Integer getIdAdministrator() {
            return idAdministrator;
      }

      public void setIdAdministrator(Integer idAdministrator) {
            this.idAdministrator = idAdministrator;
      }
}
