package com.oup.example.springbootcamel;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Bean
	CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext context) {
				log.info("################### Before Application Start ############################");
			}

			@Override
			public void afterApplicationStart(CamelContext camelContext) {
				log.info("################### After Application Start  ############################");
			}
		};
	}
//	@Bean
//	public RestConfiguration getRest() {
//		RestConfiguration restconfig = new RestConfiguration();
//		restconfig.setPort(9090);
//		restconfig.setComponent("servlet");
//		restconfig.setContextPath("/");
//
//		Map<String, Object> apiProperties = new HashMap<>();
//
//		apiProperties.put("api.title", "Device API Gateway");
//		apiProperties.put("api.version", "v1");
//
//		restconfig.setApiProperties(apiProperties);
//		restconfig.setApiContextRouteId("apiContextRouteId");
//		restconfig.setEnableCORS(true);
//
//		return restconfig;
//	}
}