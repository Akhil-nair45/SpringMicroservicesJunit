package com.example.demo;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Controller.UserController;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@SpringBootTest(classes= {ControllerMockitoTest.class})
@TestMethodOrder(OrderAnnotation.class)
public class ControllerMockitoTest {
	
	@Mock
	UserService us;
	
	@InjectMocks
	UserController uc;
	
	List<User> users;
	User u;
	
	
	@Test
	@Order(1)
	public void test_getALlUser()
	{
		users= new ArrayList<User>();
		users.add(new User(1,"Akhil","INDIA",0,"AK123"));
		users.add(new User(2,"Harshil","INDIA",0,"HA123"));
		
		when(us.getALlUser()).thenReturn(users);
		 ResponseEntity<?> res=uc.getALlUser();
		 
		 assertEquals(HttpStatus.FOUND,res.getStatusCode());
		 assertEquals(users.size(), ((List<?>) res.getBody()).size());
		 verify(us, times(1)).getALlUser();
	}
}
