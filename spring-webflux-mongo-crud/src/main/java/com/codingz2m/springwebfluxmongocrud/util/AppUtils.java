package com.codingz2m.springwebfluxmongocrud.util;

import org.springframework.beans.BeanUtils;

import com.codingz2m.springwebfluxmongocrud.dto.ProductDTO;
import com.codingz2m.springwebfluxmongocrud.entity.Product;

public class AppUtils {
	
	public static ProductDTO entityToDTO(Product product) {
		ProductDTO prodcutDTO = new  ProductDTO();
		BeanUtils.copyProperties(product, prodcutDTO);
		return prodcutDTO;
	}
	
	public static Product dTOToEntity(ProductDTO productDTO) {
		Product prodcut = new  Product();
		BeanUtils.copyProperties(productDTO, prodcut);
		return prodcut;
	}
}
