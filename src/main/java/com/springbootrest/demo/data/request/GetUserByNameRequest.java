package com.springbootrest.demo.data.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "getUserByNameRequest", propOrder = {"name"})
@XmlRootElement(name= "getUserByNameRequest", namespace = "http://www.springbootrest.com/demo")
public class GetUserByNameRequest {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
