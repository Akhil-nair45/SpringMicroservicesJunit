package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Model.Country;
import com.example.demo.Repository.ModelRepo;
import com.example.demo.Service.CountryServiceImpl;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	ModelRepo or;
	
	@InjectMocks
	CountryServiceImpl  countryService;
	
	public List<Country> myCountries;
	@Test
	@Order(1)
	public void getAllCountries() {
		List<Country> myCountries= new ArrayList<Country>();
		myCountries.add(new Country(1,"USA","NYC TIMES SQUARE"));
		myCountries.add(new Country(4, "JAPAN","ANIME"));
		
		when( or.findAll()).thenReturn(myCountries);
		assertEquals(2,countryService.getAllCountries().size());
	}
	
	
	@Test
	@Order(2)
	public void  getCountryById() {
		 Integer countryId = 1;
	        Country expectedCountry = new Country(1, "BRAZIL", "hello");

	        // Mock the repository behavior
	        when(or.findById(countryId)).thenReturn(Optional.of(expectedCountry));

	        // Act
	        Country actualCountry = countryService.getCountryById(countryId);

	        // Assert
	        Assertions.assertEquals(expectedCountry, actualCountry);
	        verify(or, times(1)).findById(countryId);
	    }
	
	@Test
	@Order(3)
	public void editCountry() {
	    // Create a sample country object with initial data
	    Country initialCountry = new Country(1, "Brazil", "Hello");

	    // Create a new country object with updated data
	    Country updatedCountry = new Country(1, "USA", "North America");

	    // Call the editCountry method and store the result
	    Country editedCountry = editCountry(initialCountry);

	    // Assert that the returned country object matches the updated country object
	    assertEquals(updatedCountry, editedCountry);
	}



	

}
