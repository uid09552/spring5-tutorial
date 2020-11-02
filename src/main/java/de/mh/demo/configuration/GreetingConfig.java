package de.mh.demo.configuration;

import de.mh.demo.services.GreetingService;
import de.mh.demo.services.MyGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class GreetingConfig {
    @Value("${mh.username}")
    private String username;
    @Value("${mh.password}")
    private String password;

    @Bean
    @Qualifier("myGreetingService1")
    public GreetingService greetingServiceConf() {
      MyGreetingService g = new MyGreetingService();
      g.setCustomName("custom configuator "+ username + " " + password);
      return g;
    }
}
