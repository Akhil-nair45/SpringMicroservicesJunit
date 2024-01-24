package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Country;

public interface CountryService {
	
	public Country savecountry(Country country);
	
	public List<Country> getAllCountries();
	
	public Country getCountryById(Integer id);
	
	public String deleteCountry(Integer id);
	
	public Country editCountry(Country country);

}
