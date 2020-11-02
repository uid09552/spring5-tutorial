package de.mh.demo.controllers;

import de.mh.demo.services.GreetingService;
import de.mh.demo.services.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Qualifier(value = "greetingRestControllerBean")//from xml
    public void setCallService(GreetingService callService) {
        this.callService = callService;
    }

    @Autowired
    @Qualifier("myGreetingService1")
    private  GreetingService greetingService2;

    private GreetingService callService;

    @RequestMapping("/api/greeting")
    public String getGreet() {
        return callService.sayHello();
    }

    @RequestMapping("/api/v2/greeting")
    public String getGreet2() {
        return greetingService2.sayHello();
    }
}
