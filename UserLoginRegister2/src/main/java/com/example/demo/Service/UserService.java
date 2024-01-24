package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService {

	
	public User addUser(User user);
	
	public User editUser(User user);
	
	public User findUserById(Integer id);
	
	public String deleteUser(Integer id);
	
	public List<User> getALlUser();
}
