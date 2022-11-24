package com.springbootrest.demo.business.service;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.data.entity.User;
import com.springbootrest.demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto findById(long userId) {
        User user = userRepository.findUserById(userId);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPassword(user.getPassword());



        return userDto;
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @Override
    public String addUser(UserDto userDto) {
        User user1 = userRepository.findUserByEmail(userDto.getEmail());
        if(user1 != null)
            return "Email already exists";
        if(userDto.getEmail() == null || userDto.getName() == null || userDto.getSurname() == null || userDto.getPassword() == null)
            return "Missing Information";

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return "User added successfully";
    }

    @Override
    public List<UserDto> findAll() {
        Optional<List<User>> optional = Optional.ofNullable(userRepository.findAll());
        if (optional.isPresent()){
            List<UserDto> userDtoList = new ArrayList<>();

            for (User user: optional.get()) {
            UserDto userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setPassword(user.getPassword());
            userDtoList.add(userDto);
            }
            return userDtoList;
        }
        return null;
    }

    @Override
    public List<UserDto> findByName(String name) {
        Optional<List<User>> optional = Optional.ofNullable(userRepository.findByName(name));

        if (optional.isPresent()){
            List<UserDto> userDtoList = new ArrayList<>();

            for (User user: optional.get()) {
                UserDto userDto = new UserDto();
                userDto.setEmail(user.getEmail());
                userDto.setName(user.getName());
                userDto.setSurname(user.getSurname());
                userDto.setPassword(user.getPassword());
                userDtoList.add(userDto);
            }
            return userDtoList;
        }
        return null;
    }
}
