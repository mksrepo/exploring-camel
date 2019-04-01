package com.stud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.bean.StudentDto;
import com.stud.camel.context.AddressIntegrationContext;
import com.stud.repo.StudentRepository;
import com.stud.util.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	AddressIntegrationContext context;

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

	@Override
	public List<StudentDto> camelExchange(List<StudentDto> students) throws Exception {
		try {
			// setup
			context.config();

			// send
			context.sendBody(students);

			// receive
			return context.receiveBody();
		} finally {
			context.close();
		}
	}

}
