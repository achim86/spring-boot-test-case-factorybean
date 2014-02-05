package test.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.myservice.MyWebService;

//@Component  see CxfConfig
public class CxfClientService 
 {
	
	Logger logger = LoggerFactory.getLogger(CxfClientService.class);

	@Autowired
	MyWebService ws; 
		
	@PostConstruct
	public void init() {
		
		logger.info("Got : "+ws);
		
	}

	public void logWSAddress() {
		
		Client c = ClientProxy.getClient(ws);
		
		String address = c.getEndpoint().getEndpointInfo().getAddress();
		logger.info("CXF ws proxy address : "+address);
		
//		ws.doIt("ss");
	}
		
}
