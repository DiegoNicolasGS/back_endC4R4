/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto4.reto4.Crud;

import com.reto4.reto4.Model.Footwears;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Diego Garzon
 */
public interface AccessoryCrud extends MongoRepository<Footwears, String> {
    
}
