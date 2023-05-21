/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.controller;

import com.example.appCars.model.Client;
import com.example.appCars.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})  //acepte todas las peticiones entrantes
@RequestMapping("/api/Client") //RequestMapping completa el endpoint
public class ClientController {

    @Autowired
    private ClientService clientservice;

    //Peticiones GET
    @GetMapping(value = "/all") //se agrega al endpoint
    public List<Client> consultartodos() {
        return clientservice.findAll();
    }

    //Peticiones POST
    @PostMapping(value = "/save")
    public ResponseEntity<Client> agregar(@RequestBody Client cliente) {
        Client newClient = clientservice.save(cliente);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
}
