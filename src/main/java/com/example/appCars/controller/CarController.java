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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookpro
 */
@RestController
@CrossOrigin("*")  //acepte todas las peticiones entrantes
@RequestMapping("/Car") //RequestMapping completa el endpoint
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
    @PutMapping(value = "/{id}")
    public ResponseEntity<Car> actualizar(@RequestBody Car car) {
        //Se busca primero el cliente
        Car newCar = carservice.findById(car.getId());
        if (newCar != null) {
            //Encontró al cliente con el id
            newCar.setBrand(car.getBrand());

            carservice.save(newCar);
        } else {
            //No lo encontró
            return new ResponseEntity<>(newCar, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newCar, HttpStatus.OK);
    }

    private void save(Car car) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
