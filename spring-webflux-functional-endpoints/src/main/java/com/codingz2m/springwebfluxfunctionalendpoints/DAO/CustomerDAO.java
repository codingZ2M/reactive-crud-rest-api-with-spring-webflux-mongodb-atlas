package com.codingz2m.springwebfluxfunctionalendpoints.DAO;

import org.springframework.stereotype.Component;

import com.codingz2m.springwebfluxfunctionalendpoints.DTO.Customer;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {  // PUBLISHER...   Browser can be SUBSCRIBER..

    public Flux<Customer> getCustomersList()  {
        return Flux.range(1,10)
        		.delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Customer(i, "customer" + i));
    }


}
