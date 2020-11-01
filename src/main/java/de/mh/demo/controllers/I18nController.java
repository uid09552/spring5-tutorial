package de.mh.demo.controllers;

import de.mh.demo.services.CallServiceDE;
import de.mh.demo.services.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nController {

    public I18nController(ICallService greetingService) {
        this.greetingService = greetingService;
    }

    private final ICallService greetingService;

    @RequestMapping("/api/say")
    public String sayHello() {
        return greetingService.call();
    }
}
