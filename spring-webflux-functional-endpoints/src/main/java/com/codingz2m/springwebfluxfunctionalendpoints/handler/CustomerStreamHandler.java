package com.codingz2m.springwebfluxfunctionalendpoints.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codingz2m.springwebfluxfunctionalendpoints.DAO.CustomerDAO;
import com.codingz2m.springwebfluxfunctionalendpoints.DTO.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

	@Autowired
	private CustomerDAO customerDAO;
	
	public Mono<ServerResponse> getCustomers(ServerRequest request){
		Flux<Customer>  customersStream = customerDAO.getCustomersList();
		return ServerResponse.ok()
				// Informing to Publisher to send stream instead of object.
				// Data will be sent as event/stream
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customersStream, Customer.class);
	}
	
	public Mono<ServerResponse> findCustomer(ServerRequest request) {
		
		int customerId = Integer.valueOf(request.pathVariable("id"));
		Mono<Customer> customerMono = customerDAO.getCustomersList()
								.filter( customer -> customer.getId() == customerId)
								.next();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customerMono, Customer.class);
	}
	
	public Mono<ServerResponse> addCustomer(ServerRequest request) {
		
		Mono<Customer> customerMono = request.bodyToMono(Customer.class);
		Mono<String> response =  customerMono.map( customer -> customer.getId() +" : " + customer.getName());
		
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(response, String.class);
		
	}
}
