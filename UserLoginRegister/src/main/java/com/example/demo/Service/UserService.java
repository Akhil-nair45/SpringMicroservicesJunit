package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService {

	public User saveUser(User user);
	
	public User editUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(Integer id);
	
	public String deleteUser(Integer id);
}
