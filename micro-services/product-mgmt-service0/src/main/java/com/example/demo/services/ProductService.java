package com.example.demo.services;

import com.example.demo.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	public String addProduct(Product  p);
	public List<Product> getAllProducts();
	public Optional<Product> getProduct(int pid);
}
