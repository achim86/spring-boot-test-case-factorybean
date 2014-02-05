package test.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/other-applicationContext.xml")
public class CustomConfig {

}
