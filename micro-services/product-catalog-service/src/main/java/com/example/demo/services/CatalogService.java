package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beans.Product;

@Service

public class CatalogService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Product> getAllProducts(){
		return restTemplate.getForObject("http://localhost:8181/products", List.class);
	}
}
