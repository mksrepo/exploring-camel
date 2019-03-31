package com.stud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.bean.StudentDto;
import com.stud.camel.context.IntegrationContext;
import com.stud.camel.route.IntegrationRoute;
import com.stud.repo.StudentRepository;
import com.stud.util.AppConstant;
import com.stud.util.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<StudentDto> getStudents() {
		return studentRepo.findAll().stream().map(StudentMapper::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		return StudentMapper.entityToDto(studentRepo.save(StudentMapper.dtoToEntity(studentDto)));
	}

	@Override
	public StudentDto updateSudent(StudentDto studentDto) {
		return StudentMapper.entityToDto(studentRepo.save(StudentMapper.dtoToEntity(studentDto)));
	}

	@Override
	public String removeStudent(Long roll) {
		studentRepo.deleteById(roll);
		return "Success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentDto> camelExchange(List<StudentDto> students) throws Exception {
		CamelContext context = IntegrationContext.config(new IntegrationRoute());
		context.createProducerTemplate().sendBody(AppConstant.DIRECT_START, students);
		return context.createConsumerTemplate().receiveBody(AppConstant.SEDA_END, ArrayList.class);
	}

}
