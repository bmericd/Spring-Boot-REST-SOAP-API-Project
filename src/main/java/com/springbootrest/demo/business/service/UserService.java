package com.springbootrest.demo.business.service;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto findById(long userId);
    UserDto findByEmail(String mail);
    List<UserDto> findAll();
    String addUser(UserDto userDto);
    List<UserDto> findByName(String name);

}
