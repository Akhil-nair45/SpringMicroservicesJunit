package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private ProductRepo repo;
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		return new ResponseEntity<>(ps.addProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/GetAll")
	public ResponseEntity<?> AllProduct(){
		return new ResponseEntity<>(ps.AllProduct(),HttpStatus.FOUND);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id){
		return new ResponseEntity<>(ps.getProductById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Product product){
		return new ResponseEntity<>(ps.editProduct(product),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		return new ResponseEntity<>(ps.deleteProduct(id),HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{cid}")
	public ResponseEntity<?> byCategory(@PathVariable int cid){
		return new ResponseEntity<>(repo.findByCidId(cid),HttpStatus.FOUND);
	}
	

}
