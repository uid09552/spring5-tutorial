package de.mh.demo.controllers;

import de.mh.demo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorRestController {
    @Autowired
    @Qualifier("myGreetingService1")
    private GreetingService greetingService;

    @RequestMapping("/api/authors")
    private String getAuthor(){
        return greetingService.sayHello();
    }
}
