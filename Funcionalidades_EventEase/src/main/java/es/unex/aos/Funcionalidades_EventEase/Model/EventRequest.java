package es.unex.aos.Funcionalidades_EventEase.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class EventRequest {

      private String name;

      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
      private LocalDate date;

      private String city;
      private String address;
      private Double minPrice;
      private Double maxPrice;
      private Integer idAdministrator;

      public EventRequest() {

      }

      public EventRequest(String name, LocalDate date, String city, String address, Double minPrice, Double maxPrice,
                  Integer idAdministrator) {
            this.name = name;
            this.date = date;
            this.city = city;
            this.address = address;
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
            this.idAdministrator = idAdministrator;
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

      @Override
      public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((date == null) ? 0 : date.hashCode());
            result = prime * result + ((city == null) ? 0 : city.hashCode());
            result = prime * result + ((address == null) ? 0 : address.hashCode());
            result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
            result = prime * result + ((maxPrice == null) ? 0 : maxPrice.hashCode());
            result = prime * result + ((idAdministrator == null) ? 0 : idAdministrator.hashCode());
            return result;
      }

      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (obj == null)
                  return false;
            if (getClass() != obj.getClass())
                  return false;
            EventRequest other = (EventRequest) obj;
            if (name == null) {
                  if (other.name != null)
                        return false;
            } else if (!name.equals(other.name))
                  return false;
            if (date == null) {
                  if (other.date != null)
                        return false;
            } else if (!date.equals(other.date))
                  return false;
            if (city == null) {
                  if (other.city != null)
                        return false;
            } else if (!city.equals(other.city))
                  return false;
            if (address == null) {
                  if (other.address != null)
                        return false;
            } else if (!address.equals(other.address))
                  return false;
            if (minPrice == null) {
                  if (other.minPrice != null)
                        return false;
            } else if (!minPrice.equals(other.minPrice))
                  return false;
            if (maxPrice == null) {
                  if (other.maxPrice != null)
                        return false;
            } else if (!maxPrice.equals(other.maxPrice))
                  return false;
            if (idAdministrator == null) {
                  if (other.idAdministrator != null)
                        return false;
            } else if (!idAdministrator.equals(other.idAdministrator))
                  return false;
            return true;
      }
}
