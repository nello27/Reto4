package com.example.appCars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Integer idMessage;

    @Column(name = "messageText")
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "car") // Nombre de la columna de la clave foránea en la tabla "message"
    //@JsonIgnoreProperties("message")
    @JsonIgnoreProperties({"messages", "reservations"})
    @Expose
    @SerializedName("car")
    private Car car;
    
    @ManyToOne
    @JoinColumn(name = "message") // Nombre de la columna de la clave foránea en la tabla "message"
    //@JsonIgnoreProperties("message")
    @JsonIgnoreProperties("car")
    @Expose
    @SerializedName("message")
    @JsonIgnore
    private Message message;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages", "reservations"})
    @Expose
    @SerializedName("client")
    private Client client;
    
    @OneToMany(mappedBy = "message")
    @JsonIgnore
    private List<Message> reservations;

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return "[" + gson.toJson(this) + "]";
    }

    public List<Message> getReservations() {
        return reservations;
    }

    public void setReservations(List<Message> reservations) {
        this.reservations = reservations;
    }

    
    
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}