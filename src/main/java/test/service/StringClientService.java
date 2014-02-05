package test.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StringClientService
 {
	
	Logger logger = LoggerFactory.getLogger(StringClientService.class);
	
	@Inject
	@Named("beanFromFactory")
	public String beanFromFactory;
	
	@Inject
	@Named("beanFromFactory2")
	public String beanFromFactory2;
	
	@PostConstruct
	public void init() {
		logInjectedStrings();
	}

	public void logInjectedStrings() {
		
		logger.info("Got beanFromFactory  : "+beanFromFactory);
		logger.info("Got beanFromFactory2 : "+beanFromFactory2);
		
	}

	
}
