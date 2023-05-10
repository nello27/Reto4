/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.appCars.service;

import com.example.appCars.model.Gama;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface GamaService {
        
        public Gama save(Gama gama);
        public void delete (Integer id);
        public Gama findById(Integer id);
        public List<Gama> findAll();
}
