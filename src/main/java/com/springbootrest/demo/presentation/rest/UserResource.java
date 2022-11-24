package com.springbootrest.demo.presentation.rest;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.business.service.UserService;
import com.springbootrest.demo.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("api/user/{userId}")
    public UserDto getUserbyId(@PathVariable("userId")long userId){
        return userService.findById(userId);
    }
    @GetMapping("api/user/email/{email}")
    public UserDto getUserbyEmail(@PathVariable("email")String email){
        return userService.findByEmail(email);
    }

    @GetMapping("api/user/all")
    public List<UserDto> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("api/user/name/{name}")
    public List<UserDto> getUserByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }

    @PostMapping("api/user/add")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

}
