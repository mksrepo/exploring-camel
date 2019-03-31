package com.stud.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stud.bean.StudentDto;

public interface StudentService {

	public List<StudentDto> getStudents();

	public StudentDto addStudent(@RequestBody StudentDto studentDto);

	public StudentDto updateSudent(@RequestBody StudentDto studentDto);

	public String removeStudent(@PathVariable Long roll);

}
