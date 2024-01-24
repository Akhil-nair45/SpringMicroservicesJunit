package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Country;
import com.example.demo.Repository.ModelRepo;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private ModelRepo or;

	@Override
	public Country savecountry(Country country) {
		return or.save(country);
	}

	@Override
	public List<Country> getAllCountries() {
		return or.findAll();
	}

	@Override
	public Country getCountryById(Integer id) {
		return or.findById(id).get();
	}

	@Override
	public String deleteCountry(Integer id) {
		Country country= or.findById(id).get();
		if(country!= null)
		{
			or.delete(country);
			return "country deleted successfully!!!";
		}
		return "Some error occured!";
	}

	@Override
	public Country editCountry(Country country) {
		return or.save(country);
	}

}
