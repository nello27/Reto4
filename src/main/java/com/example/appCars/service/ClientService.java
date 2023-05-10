/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.appCars.service;

import com.example.appCars.model.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface ClientService {
        
        public Client save(Client client);
        public void delete (Integer id);
        public Client findById(Integer id);
        public List<Client> findAll();
}
