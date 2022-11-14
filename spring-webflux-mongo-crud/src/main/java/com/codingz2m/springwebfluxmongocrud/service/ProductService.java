package com.codingz2m.springwebfluxmongocrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.codingz2m.springwebfluxmongocrud.dto.ProductDTO;
import com.codingz2m.springwebfluxmongocrud.repository.ProductRepository;
import com.codingz2m.springwebfluxmongocrud.util.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Flux<ProductDTO> getProducts(){
		return productRepository.findAll()
								.map(AppUtils::entityToDTO);
	}

	public Mono<ProductDTO> getProduct(String id){
		return productRepository.findById(id).map(AppUtils::entityToDTO);
	}
	
	public Flux<ProductDTO> getProductInRange(double min, double max){
		return productRepository.findByPriceBetween(Range.closed(min, max))
				.map(AppUtils::entityToDTO);
	}
	
	public Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDTO){
		 System.out.println("service method called ...");
		 
			return productDTO.map(AppUtils::dTOToEntity)
					//return productDTO.map( (p) ->    AppUtils.dTOToEntity(p)  )
					
					//.flatMap(productRepository::insert)
					.flatMap( (product) ->  productRepository.insert(product) )
					.map(AppUtils::entityToDTO);
		
	}
	
	public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTO, String id){
		
		return productRepository.findById(id)
						 .flatMap(product -> productDTO.map(AppUtils::dTOToEntity))
						 .doOnNext( product -> product.setId(id))
						 .flatMap(productRepository::save)
						 .map(AppUtils::entityToDTO);		
	}
	
	public Mono<Void> deleteProduct(String id){
		
		return productRepository.deleteById(id);
						
	}
}
