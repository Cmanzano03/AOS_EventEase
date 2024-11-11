package es.unex.aos.Funcionalidades_EventEase.Model;

import java.time.LocalDateTime;

public class Ticket {
    private int id;  // ID único
    private int eventId;  // Referencia al evento
    private int userId;   // Referencia al usuario
    private String ticketType;  // Tipo de ticket
    private double price;  // Precio del ticket
    private LocalDateTime purchaseDate;  // Fecha de compra

    // Constructor completo
    public Ticket(int userId, String ticketType, double price, LocalDateTime purchaseDate) {
        this.eventId = eventId;
        this.userId = userId;
        this.ticketType = ticketType;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public Ticket(TicketRequest ticketRequest) {
        this.eventId = ticketRequest.getEventId();
        this.userId = ticketRequest.getUserId();
        this.ticketType = ticketRequest.getTicketType();
        this.price = ticketRequest.getPrice();
        this.purchaseDate = ticketRequest.getPurchaseDate();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}

