/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.appCars.service;

import com.example.appCars.model.Message;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macbookpro
 */
public interface MessageService{
    
        public Message save(Message message);
        public void delete (Integer id);
        public Message findById(Integer id);
        public List<Message> findAll();
    
}
