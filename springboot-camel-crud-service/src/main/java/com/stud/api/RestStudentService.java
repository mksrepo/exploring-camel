package com.stud.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stud.bean.StudentDto;
import com.stud.util.AppConstant;

@RestController
@RequestMapping("/sms")
public interface RestStudentService {

	@GetMapping(AppConstant.URL_GET)
	public List<StudentDto> getStudent();

	@PostMapping(AppConstant.URL_ADD)
	public StudentDto addStudent(@RequestBody StudentDto user);

	@PutMapping(AppConstant.URL_UPDATE)
	public StudentDto updateSudent(@RequestBody StudentDto user);

	@DeleteMapping(AppConstant.URL_DELETE)
	public String removeStudent(@PathVariable Long roll);

}
