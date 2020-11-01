package de.mh.demo.services;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LifecycleService implements InitializingBean, BeanPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after initializing");
    }

    @PostConstruct
    public void postContruct() {
        System.out.println("post contruct");
    }


}
