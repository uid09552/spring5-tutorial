package de.mh.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("CallService")
@Profile({"EN","default"})
public class CallServiceEn implements ICallService {
    public String call() {
        return "Call";
    }
}
