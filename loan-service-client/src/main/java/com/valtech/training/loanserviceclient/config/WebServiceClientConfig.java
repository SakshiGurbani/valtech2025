package com.valtech.training.loanserviceclient.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceClientConfig {
   
	public LoanServiceWS createLoanService() {
		JaxWsProxyFactoryBean proxy=new JaxWsProxyFactoryBean();
		proxy.setServiceClass(Loan);
	}
}
