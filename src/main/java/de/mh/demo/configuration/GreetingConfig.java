package de.mh.demo.configuration;

import de.mh.demo.services.GreetingService;
import de.mh.demo.services.MyGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfig {
    @Bean
    @Qualifier("myGreetingService1")
    public GreetingService greetingServiceConf() {
      MyGreetingService g = new MyGreetingService();
      g.setCustomName("custom configuator");
      return g;
    }
}
