package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Customer;

public interface CustomerService {


	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAll();
	
	public Customer getById(Long id);
	
	public String deleteCustomer(Long id);
	
	public Customer editCustomer(Customer customer);
}
