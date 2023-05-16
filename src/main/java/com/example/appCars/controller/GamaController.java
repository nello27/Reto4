/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.controller;

import com.example.appCars.model.Gama;
import com.example.appCars.service.GamaService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookpro
 */
@RestController
@CrossOrigin("*")  //acepte todas las peticiones entrantes
@RequestMapping("/api/Gama") //RequestMapping completa el endpoint
class GamaController {

    @Autowired
    private GamaService gamaservice;
    //Peticiones GET

    @GetMapping(value = "/all") //se agrega al endpoint
    public List<Gama> consultartodos() {
        return gamaservice.findAll();
    }

    @GetMapping(value = "/all/id/{id}")
    public Gama consultarporId(@PathVariable Integer id) {
        return gamaservice.findById(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Gama> agregar(@RequestBody Gama gama) {
        Gama newCar = gamaservice.save(gama);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
}
