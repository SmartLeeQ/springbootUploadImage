package com.example.demo.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeViewController {
    @RequestMapping("/getUser")
    public Person helloWord() {
        Person p = new Person();
        p.setAge(39);
        p.setName("李小强");
        return  p;
    }
}
