package com.stud.camel.context;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class IntegrationContext {

	/**
	 * @for basic purpose route configuration
	 * @param builder
	 * @throws Exception
	 */
	public static CamelContext config(RoutesBuilder builder) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(builder);
		context.start();
		return context;
	}
	
}
