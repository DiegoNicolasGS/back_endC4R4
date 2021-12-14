package com.reto4.reto4;

import com.reto4.reto4.Crud.AccessoryCrud;
import com.reto4.reto4.Crud.OrderCrud;
import com.reto4.reto4.Crud.UserCrud;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto4Application implements CommandLineRunner {

    @Autowired
    private AccessoryCrud crudRepository;
    @Autowired
    private UserCrud userCrudRepository;
    @Autowired
    private OrderCrud orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll(); 
    }
}
