package com.codingz2m.springreactivestreams.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.springreactivestreams.DTO.Customer;
import com.codingz2m.springreactivestreams.services.CustomerService;

import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

  //Traditional Approach
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }

 // Reactive Programming Approach
    /*
      NOTE: Sending data as EVENT STREAM instead of sending as an whole object, use
      produces = MediaType.TEXT_EVENT_STREAM_VALUE
     */
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }
    
    
}