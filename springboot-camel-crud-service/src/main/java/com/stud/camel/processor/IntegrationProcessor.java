package com.stud.camel.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.stud.bean.StudentDto;
import com.stud.util.StudentMapper;

@Component("IntegrationProcessor")
public class IntegrationProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {

		// Get
		List<StudentDto> students = exchange.getIn().getBody(ArrayList.class);

		// Process
		students = students.stream().map(StudentMapper::addCountry).collect(Collectors.toList());

		// Update
		exchange.getOut().setBody(students);
	}
}