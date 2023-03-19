package com.course.work.controller;

import com.course.work.model.Client;
import com.course.work.model.Tour;
import com.course.work.repositoriy.ClientRepository;
import com.course.work.repositoriy.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
@RequestMapping("/api/info")
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

    @GetMapping("/getAllTours")
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> clients = tourRepository.findAll();
        return ResponseEntity.ok(clients);
    }
}
