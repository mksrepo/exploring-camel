package com.stud.camel.context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

import com.stud.bean.StudentDto;
import com.stud.camel.route.IntegrationRoute;
import com.stud.util.AppConstants;

@Component
public class AddressIntegrationContext implements AutoCloseable {

	private CamelContext context = new DefaultCamelContext();

	public void config() throws Exception {
		context.addRoutes(new IntegrationRoute());
		context.start();
	}

	public void sendBody(List<StudentDto> students) {
		context.createProducerTemplate().sendBody(AppConstants.DIRECT_START, students);
	}

	@SuppressWarnings("unchecked")
	public List<StudentDto> receiveBody() {
		return context.createConsumerTemplate().receiveBody(AppConstants.SEDA_END, ArrayList.class);
	}

	@Override
	public void close() throws IOException {
		try {
			context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
