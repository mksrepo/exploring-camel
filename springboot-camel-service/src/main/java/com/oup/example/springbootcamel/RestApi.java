package com.oup.example.springbootcamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApi extends RouteBuilder{

	@Override
    public void configure() {
		
//        restConfiguration()
//            .contextPath("/").apiContextPath("/api-doc")
//                .apiProperty("api.title", "Billing Script API")
//                .apiProperty("api.version", "1.0")
//                .apiProperty("cors", "true")
//                .apiContextRouteId("the-api")
//            .bindingMode(RestBindingMode.json);
//
//        rest("/").description("api")
//            .post("/").description("Receive Device Data")
//            	.consumes("text")
//                .route().routeId("postDeviceDataRoute")
//                .log("======= Device Data :: ${body}")
//                .endRest();
    }
}