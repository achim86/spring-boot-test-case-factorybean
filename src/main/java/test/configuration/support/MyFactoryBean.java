package test.configuration.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean
//	implements FactoryBean<String>
	implements FactoryBean<Object>
	{

	Logger logger = LoggerFactory.getLogger(MyFactoryBean.class);
	
	private String propertyFromConfig;
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
			myObject = "Got from config : "+propertyFromConfig;
			logger.info("Returning newly created string : "+myObject);
		}
		return myObject;
	}

	@Override
	public Class<?> getObjectType() {
//		return String.class;
		return CharSequence.class;
//		return null;  // <=== 
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
