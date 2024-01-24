package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo ur;
	
	
	@Override
	public User saveUser(User user) {
		return ur.save(user);
	}

	@Override
	public User editUser(User user) {
		return ur.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return ur.findById(id).get();
	}

	@Override
	public String deleteUser(Integer id) {
		User user = ur.findById(id).get();
		if(user!=null)
		{
			ur.delete(user);
			return "User Deleted Successfully!";
		}
		return "Some Error Occured!";
	}

}
