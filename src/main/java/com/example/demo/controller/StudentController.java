package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody
;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.EndPoints;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndPoints.StudentEndPoints.baseUrl)
@Tag(name = "3. Student Controller", description = "To perform CRUD operations on the Student")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Save new Student", description = "To Save Student details of a Section in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Student created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "409", description = "Class already exists")

	})
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(@RequestBody Student s,
			@RequestParam int sectionId) {
		StudentDto dto = service.saveStudent(s, sectionId);
		ResponseStructure<StudentDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Created",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.OK);
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update an existing Student", description = "To update the details of an existing student")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student updated successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(@RequestBody Student s, @RequestParam int id) {
		System.out.println(id);
		StudentDto dto = service.updateStudent(s, id);
		ResponseStructure<StudentDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.StudentEndPoints.deleteStudent)
	@Operation(summary = "Delete an existing Student", description = "To delete the details of a Student by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<ResponseStructure<String>> deleteStudentByID(int id) {
		service.deleteStudentByID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data deleted succesfully");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.StudentEndPoints.getStudentById, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get Student details by ID", description = "To retrieve details of the student by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<ResponseStructure<StudentDto>> getStudentByID(@PathVariable int id) {
		StudentDto dto = service.getStudentByID(id);
		ResponseStructure<StudentDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.StudentEndPoints.getAllStudentsByClass, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get all Students by Class", description = "Retrieve a list of all students in a specific class")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Students retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "No students found for the given criteria") })
	public ResponseEntity<ResponseStructure<List<StudentDto>>> getAllStudentsByClass(@RequestParam int id) {
		List<StudentDto> list = service.getAllStudentsByClass(id);
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), list);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.StudentEndPoints.getAllStudentsByClassAndSection, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get all Students by Section", description = "Retrieve a list of students in a specific section based on section_id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Students retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "No students found for the given criteria") })
	public ResponseEntity<ResponseStructure<List<StudentDto>>> getAllStudentsByClassAndSection(@RequestParam int section_id) {

		List<StudentDto> list = service.getAllStudentsByClassAndSection(section_id);
		ResponseStructure<List<StudentDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), list);

		return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure, HttpStatus.OK);
	}

}
