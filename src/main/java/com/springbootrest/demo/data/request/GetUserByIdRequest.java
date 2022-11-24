package com.springbootrest.demo.data.request;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "getUserByIdRequest", propOrder = {"userId"})
@XmlRootElement(name= "getUserByIdRequest", namespace = "http://www.springbootrest.com/demo")
public class GetUserByIdRequest {
 protected long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
