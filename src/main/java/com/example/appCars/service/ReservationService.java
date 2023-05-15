/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.appCars.service;

import com.example.appCars.model.Reservation;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface ReservationService{
    
        public Reservation save(Reservation reservation);
        public void delete (Integer id);
        public Reservation findById(Integer id);
        public List<Reservation> findAll();
}
