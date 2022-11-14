package com.codingz2m.springwebfluxfunctionalendpoints.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codingz2m.springwebfluxfunctionalendpoints.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {
	
	
	@Autowired
	private CustomerStreamHandler customerStreamHandler;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		// EXPOSING FUNCTIONAL END POINTS...
		return RouterFunctions.route()	
				.GET("/router/customers/stream", serverRequest -> customerStreamHandler.getCustomers(serverRequest))
			//	.GET("/router/customers/stream", customerStreamHandler::getCustomers)
				
				.GET("router/customers/stream/{id}", serverRequest -> customerStreamHandler.findCustomer(serverRequest))
				.POST("router/customers/stream", serverRequest -> customerStreamHandler.addCustomer(serverRequest))
				.build();
	}

}
