package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ProductRepo;
import com.example.demo.entities.Product;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductRepo repo;

	@Override
	public String addProduct(Product p) {
		repo.save(p);
		return "Product has been added successfully";
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Optional<Product> getProduct(int pid) {
		return repo.findById(pid);
	}
	
}
