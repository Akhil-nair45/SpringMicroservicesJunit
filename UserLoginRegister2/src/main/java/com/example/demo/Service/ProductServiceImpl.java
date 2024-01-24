package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo pr;

	@Override
	public Product addProduct(Product product) {
		return pr.save(product);
	}

	@Override
	public Product editProduct(Product product) {
		return pr.save(product);
	}

	@Override
	public Product getProductById(Integer id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Product> AllProduct() {
		return pr.findAll();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product= pr.findById(id).get();
		if(product!=null)
		{
			pr.delete(product);
			return "Product Deleted Successfully!";
		}
		return "Some Error Occured!";
	}
	
	
}
