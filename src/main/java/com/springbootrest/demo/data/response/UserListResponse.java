package com.springbootrest.demo.data.response;

import com.springbootrest.demo.business.dto.UserDto;
import com.springbootrest.demo.data.entity.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "UserListRequest", propOrder = {"user"})
@XmlRootElement(name= "UserListRequest", namespace = "http://www.springbootrest.com/demo")
public class UserListResponse {
    private List<UserDto> user;

    public List<UserDto> getUser() {
        return user;
    }

    public void setUser(List<UserDto> user) {
        this.user = user;
    }
}
