package com.valtech.training.loanservice.config;



import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanservice.services.LoanService;
import com.valtech.training.loanservice.services.LoanServiceImpl;

import jakarta.xml.ws.Endpoint;




@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint loanServiceWS(LoanService loanService) {
		EndpointImpl endpoint = new EndpointImpl(bus,new LoanServiceImpl(loanService));
		endpoint.setAddress("/loanService");
		endpoint.publish();
		return endpoint;

}
}
