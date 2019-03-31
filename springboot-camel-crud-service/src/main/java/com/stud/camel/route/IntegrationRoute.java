package com.stud.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.stud.camel.processor.IntegrationProcessor;
import com.stud.util.AppConstant;

@Component
public class IntegrationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(AppConstant.DIRECT_START)
		.process(new IntegrationProcessor())
		.to(AppConstant.SEDA_END);
	}
}
