package test.configuration.support;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean2 extends MyFactoryBean {

	private boolean initialized = false;
	
	@PostConstruct
	public void init() {
		logger.info("Initializing ...");   // Never called ???
		
		initialized = true;
	}
	
	@Override
	public Class<?> getObjectType() {
		Class<?> res;
		
		// simulating a non initialized CXF factory bean : JaxWsProxyFactoryBeanDefinitionParser.JAXWSSpringClientProxyFactoryBean
		// which return null before serviceClass is injected
		
//		if(initialized) { // never true ...
		if(propertyFromConfig != null) {
			// bean properties has been injected ...
			res = super.getObjectType();
		} else {
			// bean properties has NOT been injected yet...
			// CXF's JaxWsProxyFactoryBeanDefinitionParser.JAXWSSpringClientProxyFactoryBean returns null in this case
			res = null;  
		}
		logger.debug("Returning object type : "+res);
		return res; 
	}

}
