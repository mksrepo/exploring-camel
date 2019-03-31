package com.stud.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stud.bean.StudentDto;

public interface StudentService {

	List<StudentDto> getStudents();

	StudentDto addStudent(@RequestBody StudentDto studentDto);

	StudentDto updateSudent(@RequestBody StudentDto studentDto);

	String removeStudent(@PathVariable Long roll);

	List<StudentDto> camelExchange(List<StudentDto> students) throws Exception;

}
