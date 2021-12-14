/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.reto4.Repository;

import com.reto4.reto4.Crud.AccessoryCrud;
import com.reto4.reto4.Model.Footwears;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Garzon
 */
@Repository
public class AccessoryRepository {
    
    @Autowired
    private AccessoryCrud accesoryCrudRepository;

    public List<Footwears> getAll() {
        return accesoryCrudRepository.findAll();
    }

    public Optional<Footwears> getAccesory(String reference) {
        return accesoryCrudRepository.findById(reference);
    }
    
    public Footwears create(Footwears accesory) {
        return accesoryCrudRepository.save(accesory);
    }

    public void update(Footwears accesory) {
        accesoryCrudRepository.save(accesory);
    }
    
    public void delete(Footwears accesory) {
        accesoryCrudRepository.delete(accesory);
    }
    
}
