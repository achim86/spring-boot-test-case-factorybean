package test.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.myservice.MyWebService;

@Component
public class MyService 
// implements ApplicationContextAware 
 {
	

	Logger logger = LoggerFactory.getLogger(MyService.class);
	
	@Autowired
	CharSequence beanFromFactory;

	@Autowired
	MyWebService ws; 
	
//	private ApplicationContext applicationContext;
	
	@PostConstruct
	public void init() {
		
//		((ListableBeanFactory)applicationContext).
//		Map<String, Object> beans = applicationContext.getBeansOfType(Object.class);
//		for (String name : beans.keySet()) {
//			logger.info("{} : {}",name, beans.get(name).getClass());
//		}
		
		logger.info("Got : "+beanFromFactory);
		
		logger.info("Got : "+ws);
		
	}

	public void doIt() {
		ws.doIt("ss");
	}
	
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext)
//			throws BeansException {
//		this.applicationContext = applicationContext;
//	}
	
}
