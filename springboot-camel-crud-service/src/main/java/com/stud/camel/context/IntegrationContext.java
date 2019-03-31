package com.stud.camel.context;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class IntegrationContext {

	public static void config(RoutesBuilder builder) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(builder);
		context.start();
	}
}
