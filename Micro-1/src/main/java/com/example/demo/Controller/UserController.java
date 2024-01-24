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

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> adduser(@RequestBody User user)
	{
		return new ResponseEntity<>(us.addUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editUser(@RequestBody User user)
	{
		return new ResponseEntity<>(us.editUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUser(@RequestBody User user)
	{
		return new ResponseEntity<>(us.getAllUser(),HttpStatus.FOUND);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(us.getUseById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id)
	{
		return new ResponseEntity<>(us.deleteUser(id),HttpStatus.OK);
	}
}
