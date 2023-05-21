/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.appCars.dao;

import com.example.appCars.model.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface ScoreDao extends CrudRepository<Score, Integer> {
    
}
