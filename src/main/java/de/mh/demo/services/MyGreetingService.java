package de.mh.demo.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello";
    }
}

