package com.stud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stud.bean.StudentDto;
import com.stud.service.StudentService;

@RestController
public class StudentController implements RestStudentService {

	@Autowired
	StudentService studentService;

	@Override
	public List<StudentDto> getStudent() throws Exception {

		return studentService.camelExchange(studentService.getStudents());
	}

	@Override
	public StudentDto addStudent(StudentDto student) {
		return studentService.addStudent(student);

	}

	@Override
	public StudentDto updateSudent(StudentDto student) {
		return studentService.updateSudent(student);

	}

	@Override
	public String removeStudent(Long roll) {
		return studentService.removeStudent(roll);

	}

}
