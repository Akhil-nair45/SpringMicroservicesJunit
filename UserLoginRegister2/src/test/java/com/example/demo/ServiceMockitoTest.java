package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserServiceImpl;

@SpringBootTest(classes= {ServiceMockitoTest.class})
@TestMethodOrder(OrderAnnotation.class)
public class ServiceMockitoTest {

	
	@Mock
	UserRepo ur;
	
	@InjectMocks
	UserServiceImpl us;
	
//	public List<User> MyUsers;     its okay if u dont write if u want to u can!
	
	
	@Test
	@Order(1)
	public void test_getALlUser()
	{
		List<User> MyUsers=new ArrayList<User>();
		MyUsers.add(new User(1,"Akhil","INDIA",0,"AK123"));
		MyUsers.add(new User(2,"Harshil","INDIA",0,"HA123"));
		
		when(ur.findAll()).thenReturn(MyUsers);
		assertEquals(2,us.getALlUser().size());
		
	}
	
	@Test
	@Order(2)
	public void test_findUserById()
	{
		List<User> MyUsers=new ArrayList<User>();
		MyUsers.add(new User(1,"Akhil","INDIA",0,"AK123"));
		MyUsers.add(new User(2,"Harshil","INDIA",0,"HA123"));
		int UserId=1;
		
		when(ur.findById(UserId)).thenReturn(Optional.of(MyUsers.get(0)));
	        		assertEquals(UserId,us.findUserById(UserId).getId());
	}
	
	@Test
	@Order(3)
	public void test_addUser()
	{
		User user= new User(3,"Brijesh","INDIA",0,"BJ123");
		
		when(ur.save(user)).thenReturn(user);
		assertEquals(user,ur.save(user));
	}
	
	@Test
	@Order(4)
	public void test_editUser()
	{
		User user= new User(3,"Brijesh","INDIA",0,"BJ123");
		
		when(ur.save(user)).thenReturn(user);
		 assertEquals(user,ur.save(user));
	}
	
	@Test
	@Order(5)
	public void test_deleteUser()
	{
		User user= new User(3,"Brijesh","INDIA",0,"BJ123");
		ur.delete(user);
		verify(ur,times(1)).delete(user);
	}
}
