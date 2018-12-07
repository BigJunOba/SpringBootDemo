package com.springboot.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.database.properties.GirlProperties;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @Value("${cupSize}")
    private String cupSize;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize() + " " + girlProperties.getAge();
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display() {
        return cupSize;
    }
}
