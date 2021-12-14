/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto4.reto4.Sevice;

import com.reto4.reto4.Model.Footwears;
import com.reto4.reto4.Repository.AccessoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Garzon
 */
@Service
public class AccessoryService {
    @Autowired
    private AccessoryRepository accesoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Footwears> getAll() {
        return accesoryRepository.getAll();
    }

    public Optional<Footwears> getAccesory(String reference) {
        return accesoryRepository.getAccesory(reference);
    }

    public Footwears create(Footwears accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return accesoryRepository.create(accesory);
        }
    }
    
    public Footwears update(Footwears foot) {

        if (foot.getReference() != null) {
            Optional<Footwears> accesoryDb = accesoryRepository.getAccesory(foot.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (foot.getBrand()!= null) {
                    accesoryDb.get().setBrand(foot.getBrand());
                }
                
                if (foot.getCategory() != null) {
                    accesoryDb.get().setCategory(foot.getCategory());
                }
                
                if (foot.getMaterial()!= null) {
                    accesoryDb.get().setMaterial(foot.getMaterial());
                }
                
                if (foot.getGender()!= null) {
                    accesoryDb.get().setGender(foot.getGender());
                }
                
                if (foot.getSize()!= null) {
                    accesoryDb.get().setSize(foot.getSize());
                }
                
                if (foot.getDescription() != null) {
                    accesoryDb.get().setDescription(foot.getDescription());
                }
                
                if (foot.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(foot.getPrice());
                }
                if (foot.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(foot.getQuantity());
                }
                if (foot.getPhotography() != null) {
                    accesoryDb.get().setPhotography(foot.getPhotography());
                }
                accesoryDb.get().setAvailability(foot.isAvailability());
                accesoryRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return foot;
            }
        } else {
            return foot;
        }
    }
    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            accesoryRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
