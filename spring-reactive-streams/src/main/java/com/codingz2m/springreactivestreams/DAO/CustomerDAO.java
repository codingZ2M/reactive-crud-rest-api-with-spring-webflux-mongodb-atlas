package com.codingz2m.springreactivestreams.DAO;


import org.springframework.stereotype.Component;

import com.codingz2m.springreactivestreams.DTO.Customer;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {  // PUBLISHER...   Browser can be SUBSCRIBER..


    private static void sleepExecution(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Traditional Approach.. 
    /*
     * Until it process 10 records, consumer(subscriber) of the app will not get the response. 
     */
    public List<Customer> getCustomers()  {
        return IntStream.rangeClosed(1, 10)
                .peek( i -> CustomerDAO.sleepExecution() )
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }


    // Reactive Programming Approach.. 
    /*
      While records are processed, consumer(subscriber) of the app will
      get the data as an EVENT STREAM 
     */
    public Flux<Customer> getCustomersStream()  {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing the " + i  + " object"))
                .map( i -> new Customer(i, "customer" + i));
    }


}