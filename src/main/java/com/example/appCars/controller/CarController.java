/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appCars.controller;

import com.example.appCars.model.Car;
import com.example.appCars.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/Car") //RequestMapping completa el endpoint
public class CarController {

    @Autowired
    private CarService carservice;

    //Peticiones GET
    @GetMapping(value = "/all") //se agrega al endpoint
    public List<Car> consultartodos() {
        return carservice.findAll();
    }

    @GetMapping(value = "/all/id/{id}")
    public Car consultarporId(@PathVariable Integer id) {
        return carservice.findById(id);
    }

    //Peticiones POST
    @PostMapping(value = "/save")
    public ResponseEntity<Car> agregar(@RequestBody Car car) {
        Car newCar = carservice.save(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    //Petición PUT para actualizar
    @PutMapping(value = "/update")

    public ResponseEntity<Car> actualizar(@RequestBody Car car) {
        // Obtener el ID del objeto Car del JSON
        Integer id = car.getIdCar();

        // Buscar el carro por su ID
        Car newCar = carservice.findById(id);
        if (newCar != null) {
            // Actualizar los campos del carro con los datos del CarRequest
            newCar.setName(car.getName());
            newCar.setBrand(car.getBrand());
            newCar.setYear(car.getYear());
            newCar.setDescription(car.getDescription());

            Car updatedCar = carservice.save(newCar);

            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            // No lo encontró
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        // Buscar el carro por su ID
        Car car = carservice.findById(id);
        if (car != null) {
            // Eliminar el carro
            carservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            // No se encontró el carro
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
