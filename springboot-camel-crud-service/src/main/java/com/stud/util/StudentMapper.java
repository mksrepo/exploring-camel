package com.stud.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stud.entity.StudentEntity;
import com.stud.model.AuthResponse;
import com.stud.model.Student;

public class StudentMapper {
	public static Student entityToDto(StudentEntity entity) {
		return new ObjectMapper().convertValue(entity, Student.class);
	}

	public static StudentEntity dtoToEntity(Student user) {
		return new ObjectMapper().convertValue(user, StudentEntity.class);
	}

	public static Student addCountry(Student studentDto) {
		studentDto.setAddress(new StringBuilder()
				.append(studentDto.getAddress())
				.append(AppConstants.COMMA_SEPARATOR)
				.append(AppConstants.KEYWORD_INDIA)
				.toString());
		return studentDto;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Student addEducationDetails(Student studentDto) {
		String Url = "http://localhost:59575/getAllUsers";
		RestTemplate restTemplate = new RestTemplate();

		// setting the headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " +  getOAuthToken("userclient:usersecret"));
		headers.add("client_id", "userclient");
		headers.add("client_secret", "usersecret");
		// Updating Education details
		studentDto.setEducationDetials(restTemplate.exchange(Url, HttpMethod.GET, new HttpEntity(headers), String.class).getBody());
		return studentDto;
	}
	
	private static String getOAuthToken(String credental) {
		byte[] plainCredsBytes = credental.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		String authUri = "http://localhost:7777/oauth/token";
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64Creds);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("scope", "resource-server-write");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<AuthResponse> response = new RestTemplate().postForEntity(authUri, request, AuthResponse.class);
		String oathToken = (String) response.getBody().getAccess_token();

		return oathToken;
	}
	
}
