/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.controller;

import com.example.appCars.model.Reservation;
import com.example.appCars.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookpro
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})  //acepte todas las peticiones entrantes
@RequestMapping("/api/Reservation") //RequestMapping completa el endpoint
public class ReservationController {

    @Autowired
    private ReservationService Reservationservice;
    //Peticiones GET

    @GetMapping(value = "/all") //se agrega al endpoint
    public List<Reservation> consultartodos() {
        return Reservationservice.findAll();
    }

    @GetMapping(value = "/all/id/{id}")
    public Reservation consultarporId(@PathVariable Integer id) {
        return Reservationservice.findById(id);
    }

    //Peticiones POST
    @PostMapping(value = "/save")
    public ResponseEntity<Reservation> agregar(@RequestBody Reservation reservation) {
        Reservation newReservation = Reservationservice.save(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }
}
