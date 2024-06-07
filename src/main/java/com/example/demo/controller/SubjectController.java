package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.configuration.EndPoints;
import com.example.demo.entity.Subject;
import com.example.demo.entity.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(EndPoints.SubjectEndPoints.baseUrl)
@Tag(name = "Subject Controller", description = "To perform CRUD operations on the  Subjects")
public class SubjectController {

	@PostMapping
	@Operation(summary = "Save new Subject Of Class ", description = "To Save Subject details of a Class by class_id in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })

	public ResponseEntity<ResponseStructure<Subject>> saveSubject(@RequestBody Subject s,int id) {
		return null;
	}

	@PutMapping
	@Operation(summary = "Update's an existing Subject of a Class", description = "To Update the details of an existing Subject of a Class in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> updateSubject(@RequestBody Subject s) {
		return null;
	}

	@DeleteMapping(EndPoints.SubjectEndPoints.deleteSubjectByID)
	@Operation(summary = "Delete's an existing Subject of an Class", description = "To delete the details of Subject by ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteSubjectByID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.SubjectEndPoints.getSubjectById)
	@Operation(summary = "Get Subject details by ID", description = "To Retrieve details of the Subject by their ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Subject>> getSubjectByID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.SubjectEndPoints.getAllSubjectByClassID)
	@Operation(summary = "Get Subject details by ID", description = "To Retrieve List of the Subject by the Class_Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Subject>> getSubjectsByClassID(@PathVariable int id) {
		return null;
	}

}
