package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService ur;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return new ResponseEntity<>(ur.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Integer id){
		return new ResponseEntity<>(ur.findUserById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<?> getALlUser(){
		return new ResponseEntity<>(ur.getALlUser(),HttpStatus.FOUND);
	}
	
	@PatchMapping("/edit")
	public ResponseEntity<?> editUser(@RequestBody User user){
		return new ResponseEntity<>(ur.editUser(user),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return new ResponseEntity<>(ur.deleteUser(id),HttpStatus.OK);
	}
}
