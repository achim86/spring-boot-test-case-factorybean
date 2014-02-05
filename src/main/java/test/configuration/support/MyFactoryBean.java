package test.configuration.support;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean
	implements FactoryBean<String>
	{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String propertyFromConfig;
	private String myObject;
	
	public String getPropertyFromConfig() {
		return propertyFromConfig;
	}

	public void setPropertyFromConfig(String propertyFromConfig) {
		this.propertyFromConfig = propertyFromConfig;
		logger.info("property from config set to "+ propertyFromConfig);
	}

	@Override
	public String getObject() throws Exception {
		if(myObject != null) {
			logger.info("Returning already created string : "+myObject);
		} else {
			myObject = "propertyFromConfig value : "+propertyFromConfig;
			logger.info("Returning newly created string : "+myObject);
		}
		return myObject;
	}

	@PostConstruct
	public void init() {
		logger.info("Initializing ...");
	}
	
	@Override
	public Class<?> getObjectType() {
		return String.class; 
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
