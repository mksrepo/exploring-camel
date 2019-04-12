package com.stud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stud.model.Student;
import com.stud.service.StudentService;

@RestController
public class StudentController implements RestStudentService {

	@Autowired
	StudentService studentService;

	@Override
	public List<Student> getStudent() throws Exception {
		return  // Calling Camel exchange
				studentService.camelExchange(
					// Fetching from DB
					studentService.getStudents()
				);
	}

	@Override
	public Student addStudent(Student student) {
		return studentService.addStudent(student);

	}

	@Override
	public Student updateSudent(Student student) {
		return studentService.updateSudent(student);

	}

	@Override
	public String removeStudent(Long roll) {
		return studentService.removeStudent(roll);

	}

}
