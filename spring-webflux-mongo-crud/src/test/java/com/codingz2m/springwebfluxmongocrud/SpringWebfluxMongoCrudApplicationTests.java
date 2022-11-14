package com.codingz2m.springwebfluxmongocrud;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.codingz2m.springwebfluxmongocrud.controller.ProductController;
import com.codingz2m.springwebfluxmongocrud.dto.ProductDTO;
import com.codingz2m.springwebfluxmongocrud.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

 //Testing Async REST APIs with @WebFluxTest and WebTestClient

@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
class SpringWebfluxMongoCrudApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void addProductTest() {
		Mono<ProductDTO> productDTOMono = Mono.just(new ProductDTO("1", "Samsung Mobile 23RT", 1, 11000.00d));
		
		when(productService.saveProduct(productDTOMono)).thenReturn(productDTOMono);
		
		 webTestClient.post().uri("/products").body(Mono.just(productDTOMono), ProductDTO.class)
		.exchange()
		.expectStatus().isOk();
	}
	
	@Test
	public void getProductsTest() {
		
		Flux<ProductDTO> productDTOFlux = Flux.just(new ProductDTO("1", "Samsung Mobile 23RT", 1, 11000.00d),
													new ProductDTO("2", "HP Laptop 23RT", 1, 13000.00d));
		when(productService.getProducts()).thenReturn(productDTOFlux);	
		
		Flux<ProductDTO> responseBody =	webTestClient.get().uri("/products")
							.exchange()
							.expectStatus().isOk()
							.returnResult(ProductDTO.class)
							.getResponseBody();
		
		StepVerifier.create(responseBody)
		.expectSubscription()
		.expectNext(new ProductDTO("1", "Samsung Mobile 23RT", 1, 11000.00d))
		.expectNext(new ProductDTO("2", "HP Laptop 23RT", 1, 13000.00d))
		.verifyComplete();
	}		
	
	
	@Test
	public void getProductTest() {
		Mono<ProductDTO> productDTOMono = Mono.just(new ProductDTO("1", "Samsung Mobile 23RT", 1, 11000.00d));
		when(productService.getProduct(any())).thenReturn(productDTOMono);	
		
		Flux<ProductDTO> responseBody =	webTestClient.get().uri("/products/1")
				.exchange()
				.expectStatus().isOk()
				.returnResult(ProductDTO.class)
				.getResponseBody();
		
		StepVerifier.create(responseBody)
		.expectSubscription()
		.expectNextMatches( productDTO -> productDTO.getId().equals("1"))
		.verifyComplete();
	}
	
	@Test
	public void updateProductTest() {
		Mono<ProductDTO> productDTOMono = Mono.just(new ProductDTO("1", "Samsung Mobile 23RT", 1, 11000.00d));
		when(productService.updateProduct(productDTOMono, "1")).thenReturn(productDTOMono);	
		
		 webTestClient.put().uri("/products/1").body(Mono.just(productDTOMono), ProductDTO.class)
		.exchange()
		.expectStatus().isOk();
	}
	
	@Test
	public void deleteProductTest() {
		
		when(productService.deleteProduct(any())).thenReturn(Mono.empty());	
		
		 webTestClient.delete().uri("/products/1")
			.exchange()
			.expectStatus().isOk();
	}

	
}	
