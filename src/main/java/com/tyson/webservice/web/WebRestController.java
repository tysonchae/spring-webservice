package com.tyson.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oolong on 2018-05-12.
 */
@RestController
public class WebRestController {

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }
}
