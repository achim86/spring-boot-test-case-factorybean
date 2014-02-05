package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import test.service.MyService;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
		
		MyService bean = app.getBean(MyService.class);
		bean.doIt();
		
		
	}
}
