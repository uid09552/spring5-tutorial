package de.mh.demo.services;


import org.springframework.stereotype.Service;

@Service
public class YourGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello yours";
    }
}

