package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Tour;
import com.example.demo.repositoriy.ClientRepository;
import com.example.demo.repositoriy.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TourRepository tourRepository;
    @GetMapping("/cl")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllTours")
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> clients = tourRepository.findAll();
        return ResponseEntity.ok(clients);
    }

}
