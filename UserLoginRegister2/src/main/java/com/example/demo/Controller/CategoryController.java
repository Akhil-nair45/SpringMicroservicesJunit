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

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;

@RestController
@RequestMapping("/Category")
public class CategoryController {

	
	@Autowired
	private CategoryService cr;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category cat){
		return new ResponseEntity<>(cr.addCategory(cat),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> allCategory(){
		return new ResponseEntity<>(cr.allCategory(),HttpStatus.FOUND);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
		return new ResponseEntity<>(cr.getCategoryById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editCategory(@RequestBody Category cat){
		return new ResponseEntity<>(cr.editCategory(cat),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		return new ResponseEntity<>(cr.deleteCategory(id),HttpStatus.OK);
	}
}
