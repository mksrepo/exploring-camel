package com.stud.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stud.model.Student;
import com.stud.util.AppConstants;

@RequestMapping(AppConstants.URL_ROOT)
public interface RestStudentService {

	@GetMapping(AppConstants.URL_GET)
	public List<Student> getStudent() throws Exception;

	@PostMapping(AppConstants.URL_ADD)
	public Student addStudent(@RequestBody Student user);

	@PutMapping(AppConstants.URL_UPDATE)
	public Student updateSudent(@RequestBody Student user);

	@DeleteMapping(AppConstants.URL_DELETE)
	public String removeStudent(@PathVariable Long roll);

}
