package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return ps.getAllProducts();
	}
	
	@GetMapping("/products/{pid}")
	public Optional<Product> getMethodName(@PathVariable int pid) {
		return ps.getProduct(pid);
	}
	
	
	@PostMapping("/products")
	public String addProduct(@RequestBody Product p) {
		return ps.addProduct(p);
	}
	
}
