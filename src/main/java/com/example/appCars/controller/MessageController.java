/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.controller;

import com.example.appCars.model.Message;
import com.example.appCars.service.MessageService;
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
@RequestMapping("/api/Message") //RequestMapping completa el endpoint
public class MessageController {

    @Autowired
    private MessageService messageservice;
    //Peticiones GET

    @GetMapping(value = "/all") //se agrega al endpoint
    public List<Message> consultartodos() {
        return messageservice.findAll();
    }

    @GetMapping(value = "/all/id/{id}")
    public Message consultarporId(@PathVariable Integer id) {
        return messageservice.findById(id);
    }

    //Peticiones POST
    @PostMapping(value = "/save")
    public ResponseEntity<Message> agregar(@RequestBody Message message) {
        Message newMessage = messageservice.save(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }

}
