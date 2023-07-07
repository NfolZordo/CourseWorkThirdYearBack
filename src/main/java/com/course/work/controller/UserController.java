package com.course.work.controller;

import com.course.work.model.Client;
import com.course.work.model.Order;
import com.course.work.model.Tour;
import com.course.work.model.Worker;
import com.course.work.repositoriy.ClientRepository;
import com.course.work.repositoriy.OrderRepository;
import com.course.work.repositoriy.TourRepository;
import com.course.work.repositoriy.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TourRepository tourRepository;

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(
            @RequestParam int clientId,
            @RequestParam int tourId,
            @RequestParam LocalDate dataOrder,
            @RequestParam int numberDays) {

        try {
            Client client = clientRepository.findById(clientId)
                    .orElseThrow(() -> new IllegalArgumentException("Client not found with ID: " + clientId));

            Tour tour = tourRepository.findById(tourId)
                    .orElseThrow(() -> new IllegalArgumentException("Tour not found with ID: " + tourId));

            Order order = new Order();
            order.setClient(client);
            order.setTour(tour);
            order.setDataOrder(dataOrder);
            order.setNumberDays(numberDays);

            orderRepository.save(order);

            return ResponseEntity.ok("Order added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add order: " + e.getMessage());
        }
    }
}
