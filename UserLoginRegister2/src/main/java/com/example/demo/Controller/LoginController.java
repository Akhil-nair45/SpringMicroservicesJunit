package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Login;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;

@RestController
public class LoginController {

	@Autowired
	private UserRepo ur;
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        User user = ur.findByName(login.getName());
        
        if (user == null) {
            // User not found
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        	return new ResponseEntity<>("No Such User Present!", HttpStatus.UNAUTHORIZED);
        }
        //this method is for valid
//        if (user.getPassword().equals(login.getPassword())) {
//            // valid password
//            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
//        }
        
        //this method is for unvalid and if u r using any of these method do the different in else like if valid then in else invalid and vice versa
        if (!user.getPassword().equals(login.getPassword())) {
            // valid password
            return ResponseEntity.status(HttpStatus.OK).body("Invalid Username and password");
        }
        
        
//        // unSuccessful login
//        return ResponseEntity.ok().body("Invalid Username and password");
        
     // Successful login
        return ResponseEntity.ok().body("Login successfull!");
    }
}

