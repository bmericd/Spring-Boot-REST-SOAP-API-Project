package com.springbootrest.demo.data.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "getUserByEmailRequest", propOrder = {"email"})
@XmlRootElement(name= "getUserByEmailRequest", namespace = "http://www.springbootrest.com/demo")
public class GetUserByEmailRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
