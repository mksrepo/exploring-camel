package com.stud.camel.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stud.model.Student;
import com.stud.util.AppConstants;

@Component
public class AddressIntegrationContext {

	@Autowired
	private CamelContext context;

	public void sendBody(List<Student> students) {
		context.createProducerTemplate().sendBody(AppConstants.DIRECT_START, students);
	}

	@SuppressWarnings("unchecked")
	public List<Student> receiveBody() {
		return context.createConsumerTemplate().receiveBody(AppConstants.SEDA_END, ArrayList.class);
	}
}
