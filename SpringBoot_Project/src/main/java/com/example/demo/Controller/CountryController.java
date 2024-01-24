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

import com.example.demo.Model.Country;
import com.example.demo.Service.CountryServiceImpl;

@RestController
@RequestMapping("/Country")
public class CountryController {
	
	@Autowired
	private CountryServiceImpl cs;
	
	@PostMapping("/add")
	public ResponseEntity<?> savecountry(@RequestBody Country country) {
		return new ResponseEntity<>(cs.savecountry(country), HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllCountries() {
		return new ResponseEntity<>(cs.getAllCountries(),HttpStatus.FOUND);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getCountryById(@PathVariable Integer id) {
		return new ResponseEntity<>(cs.getCountryById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable Integer id) {
		return new ResponseEntity<>(cs.deleteCountry(id),HttpStatus.OK);
	}
	
	@PutMapping("/editCountry/{id}")
	public ResponseEntity<?> editCountry(@RequestBody Country country) {
		return new ResponseEntity<>(cs.savecountry(country),HttpStatus.CREATED);
	}
	
	

}
