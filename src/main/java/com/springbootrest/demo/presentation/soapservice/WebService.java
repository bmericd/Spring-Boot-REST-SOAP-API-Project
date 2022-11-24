package com.springbootrest.demo.presentation.soapservice;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.business.service.UserService;
import com.springbootrest.demo.data.entity.User;
import com.springbootrest.demo.data.request.AddUserRequest;
import com.springbootrest.demo.data.request.GetUserByEmailRequest;
import com.springbootrest.demo.data.request.GetUserByIdRequest;
import com.springbootrest.demo.data.request.GetUserByNameRequest;
import com.springbootrest.demo.data.response.UserListResponse;
import com.springbootrest.demo.data.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class WebService {
    public static final String NAMESPACE_URI = "http://www.springbootrest.com/demo";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public JAXBElement<UserListResponse> getAllUsers(){

        List<UserResponse> userResponseList = new ArrayList<>();
        List<UserDto> userDtoList = userService.findAll();

        UserListResponse userListResponse = new UserListResponse();


        userDtoList.forEach(item -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(item.getName());
            userResponse.setPassword(item.getPassword());
            userResponse.setEmail(item.getEmail());
            userResponse.setSurname(item.getSurname());
            userResponseList.add(userResponse);
        });

        userListResponse.setUser(userDtoList);

        return createResponseJaxbElement(userListResponse, UserListResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByNameRequest")
    @ResponsePayload
    public JAXBElement<UserListResponse> getUserByName(@RequestPayload JAXBElement<GetUserByNameRequest> request){


        List<UserResponse> userResponseList = new ArrayList<>();
        List<UserDto> userDtoList = userService.findByName(request.getValue().getName());

        UserListResponse userListResponse = new UserListResponse();


        userDtoList.forEach(item -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(item.getName());
            userResponse.setPassword(item.getPassword());
            userResponse.setEmail(item.getEmail());
            userResponse.setSurname(item.getSurname());
            userResponseList.add(userResponse);
        });

        userListResponse.setUser(userDtoList);

        return createResponseJaxbElement(userListResponse, UserListResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public JAXBElement<UserResponse> getUserById(@RequestPayload JAXBElement<GetUserByIdRequest> request){


        UserResponse userResponse = new UserResponse();
        UserDto userDto = userService.findById(request.getValue().getUserId());
        userResponse.setName(userDto.getName());
        userResponse.setPassword(userDto.getPassword());
        userResponse.setEmail(userDto.getEmail());
        userResponse.setSurname(userDto.getSurname());

        return createResponseJaxbElement(userResponse, UserResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByEmailRequest")
    @ResponsePayload
    public JAXBElement<UserResponse> getUserByEmail(@RequestPayload JAXBElement<GetUserByEmailRequest> request){


        UserResponse userResponse = new UserResponse();
        UserDto userDto = userService.findByEmail(request.getValue().getEmail());
        userResponse.setName(userDto.getName());
        userResponse.setPassword(userDto.getPassword());
        userResponse.setEmail(userDto.getEmail());
        userResponse.setSurname(userDto.getSurname());

        return createResponseJaxbElement(userResponse, UserResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public JAXBElement<String> addUser(@RequestPayload JAXBElement<AddUserRequest> request){

        AddUserRequest addUserRequest = request.getValue();

        UserDto userDto = new UserDto();
        userDto.setName(addUserRequest.getName());
        userDto.setSurname(addUserRequest.getSurname());
        userDto.setEmail(addUserRequest.getEmail());
        userDto.setPassword(addUserRequest.getPassword());
        userService.addUser(userDto);

        return createResponseJaxbElement("User is added", String.class);
    }

    private <T> JAXBElement<T> createResponseJaxbElement(T object, Class<T> clazz) {

        return new JAXBElement<>(new QName(NAMESPACE_URI, clazz.getSimpleName()), clazz, object);

    }



}
