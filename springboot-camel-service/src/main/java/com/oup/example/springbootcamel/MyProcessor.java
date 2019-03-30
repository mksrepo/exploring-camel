package com.oup.example.springbootcamel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("myProcessor")
public class MyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();
		String body = message.getBody(String.class);

		body = body + " Xyx";

		message.setBody(body);

	}
}