/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer idReservation;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "devolutionDate")
    private Date devolutionDate;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "car") // Nombre de la columna de la clave foránea en la tabla "message"
    @JsonIgnoreProperties({"client", "reservations"})
    //"car", "client", "reservations"
    private Car car;

    @ManyToOne
    @JoinColumn(name = "messages")
    //@JsonIgnoreProperties({"car","messages","client"})
    @JsonIgnore
    private Message messages;

    @ManyToOne
    @JoinColumn(name = "client") // Nombre de la columna de la clave foránea en la tabla "message"
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    @Column(name = "score")
    private String score;

    @PrePersist
    public void prePersist() {
        this.status = "created";
        // Obtener el objeto Message con ID 1 desde la base de datos o el repositorio
        Message message = new Message();
        message.setIdMessage(1);

        this.messages = message;
    }

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Message orElse(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
