/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.appCars.service;

import com.example.appCars.model.Car;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface CarService{
    
        public Car save(Car car);
        public void delete (Integer id);
        public Car findById(Integer id);
        public List<Car> findAll();
}
