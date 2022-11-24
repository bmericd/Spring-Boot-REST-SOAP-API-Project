package com.springbootrest.demo;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.business.service.UserService;
import com.springbootrest.demo.data.repository.UserRepository;
import com.springbootrest.demo.data.response.UserResponse;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserService userService;


	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser(){
	UserDto userDto = new UserDto();
	userDto.setName("Alp");
	userDto.setSurname("Demirci");
	userDto.setEmail("alp@gmail.com");
	userDto.setPassword("2323");
	userService.addUser(userDto);
	}

	@Test
	public void testFailCreateUser(){
		UserDto userDto = new UserDto();
		userDto.setName("Yiğit");
		userDto.setEmail("yiğit@gmail.com");
		userService.addUser(userDto);
	}

	@Test
	public void testGetAllUsers(){
	userService.findAll();
	}

	@Test
	public void  testGetUserById(){
	userService.findById(1);
	}

	@Test
	public void testGetUserByName(){
	userService.findByName("Meriç");
	}

}
