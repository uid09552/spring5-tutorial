package de.mh.demo.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyGreetingService implements GreetingService {
    private String customName;
    public void setCustomName(String name) {
        customName = name;
    }
    @Override
    public String sayHello() {
        return customName;
    }
}

