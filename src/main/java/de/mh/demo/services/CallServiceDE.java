package de.mh.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("CallService")
@Profile("DE")
public class CallServiceDE implements ICallService {
    public String call() {
        return "Rufe";
    }
}
