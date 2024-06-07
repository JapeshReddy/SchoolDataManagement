package com.example.demo.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.configuration.EndPoints;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.entity.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(EndPoints.StudentEndPoints.baseUrl)
@Tag(name = "Student Controller",description = "To perform CRUD operations on the Student")
public class StudentController {

	@PostMapping
	@Operation(summary = "Save new Student ", description = "To Save  Student details of a Section in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student s,@RequestParam int sectionId) {


		return null;
	}

	@PutMapping
	@Operation(summary = "Update's an existing Student", description = "To Update the details of an existing student ")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> updateStudent(@RequestBody Student s) {
		return null;
	}

	@DeleteMapping(EndPoints.StudentEndPoints.deleteStudent)
	@Operation(summary = "Delete's an existing data", description = "To delete the details of Student by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteStudentByID(int id) {
		return null;
	}

	@GetMapping(EndPoints.StudentEndPoints.getStudentById)
	@Operation(summary = "Get Student details by ID", description = "To Retrieve details of the student by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Student>> getStudentByID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.StudentEndPoints.getAllStudentsByClass)
	@Operation(summary = "Get all Students by Class and Year", description = "Retrieve a list of all students in a specific class based on  academic_year")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudentsByClass(@RequestParam int id,
			@RequestParam int year) {
		return null;
	}

	@GetMapping(EndPoints.StudentEndPoints.getAllStudentsByClassAndSection)
	@Operation(summary = "Get all Students by Class, Section and Year", description = "Retrieve a list of students in a specific Section based on  section_id and academic_year and class_id")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudentsByClassAndSection(@RequestParam int id,
			@RequestParam int section, int year) {
		return null;
	}

}
