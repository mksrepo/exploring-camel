package com.stud.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stud.model.Student;

public interface StudentService {

	List<Student> getStudents();

	Student addStudent(@RequestBody Student studentDto);

	Student updateSudent(@RequestBody Student studentDto);

	String removeStudent(@PathVariable Long roll);

	List<Student> camelExchange(List<Student> students) throws Exception;

}
