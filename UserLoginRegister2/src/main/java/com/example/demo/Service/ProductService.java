package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;

public interface ProductService {

	
	public Product addProduct(Product product);
	
	public Product editProduct(Product product);
	
	public Product getProductById(Integer id);
	
	public List<Product> AllProduct();
	
	public String deleteProduct(Integer id);
}
