package com.stud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.camel.context.AddressIntegrationContext;
import com.stud.model.Student;
import com.stud.repo.StudentRepository;
import com.stud.util.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	AddressIntegrationContext context;

	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll().stream()
				// Converting from Entity to DTO
				.map(StudentMapper::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public Student addStudent(Student student) {
		return StudentMapper.entityToDto(studentRepo.save(StudentMapper.dtoToEntity(student)));
	}

	@Override
	public Student updateSudent(Student student) {
		return StudentMapper.entityToDto(studentRepo.save(StudentMapper.dtoToEntity(student)));
	}

	@Override
	public String removeStudent(Long roll) {
		studentRepo.deleteById(roll);
		return "Success";
	}

	@Override
	public List<Student> camelExchange(List<Student> students) throws Exception {
		// Sending data to Router
		context.sendBody(students);
		// Receiving data from Router
		return context.receiveBody();
	}

}
