package com.stud.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.stud.camel.processor.IntegrationProcessor;
import com.stud.util.AppConstants;

@Component
public class IntegrationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(AppConstants.DIRECT_START)
		.process(new IntegrationProcessor())
		.to(AppConstants.SEDA_END);
	}
}
