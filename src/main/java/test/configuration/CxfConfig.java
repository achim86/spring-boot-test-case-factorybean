package test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import test.service.CxfClientService;



@Configuration // DISABLED 

@ImportResource("classpath:/cxf-applicationContext.xml")
public class CxfConfig {

	@Bean
	public CxfClientService cxfClientService() {
		return new CxfClientService();
	}
}
