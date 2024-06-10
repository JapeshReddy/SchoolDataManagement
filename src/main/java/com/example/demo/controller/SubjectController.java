package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.EndPoints;
import com.example.demo.dto.SubjectDto;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndPoints.SubjectEndPoints.baseUrl)
@Tag(name = "4. Subject Controller", description = "To perform CRUD operations on the  Subjects")
public class SubjectController {

	@Autowired
	private SubjectService service;

	@PostMapping
	@Operation(summary = "Save new Subject of Class", description = "To save Subject details of a Class by class_id in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Subject created successfully"),
			@ApiResponse(responseCode = "409", description = "Subject with the same code already exists") })
	public ResponseEntity<ResponseStructure<SubjectDto>> saveSubject(@RequestBody Subject s,
			@RequestParam int class_id) {
		SubjectDto dto = service.saveSubject(s, class_id);
		ResponseStructure<SubjectDto> structure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Created",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<SubjectDto>>(structure, HttpStatus.CREATED);
	}

	@PutMapping
	@Operation(summary = "Update an existing Subject of a Class", description = "To update the details of an existing Subject of a Class in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Subject updated successfully"),
			@ApiResponse(responseCode = "404", description = "Subject not found") })
	public ResponseEntity<ResponseStructure<SubjectDto>> updateSubject(@RequestBody Subject s, @RequestParam int id) {
		SubjectDto dto = service.updateSubject(s, id);
		ResponseStructure<SubjectDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<SubjectDto>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.SubjectEndPoints.deleteSubjectByID)
	@Operation(summary = "Delete an existing Subject of a Class", description = "To delete the details of Subject by ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Subject deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Subject not found") })
	public ResponseEntity<ResponseStructure<String>> deleteSubjectByID(@PathVariable int id) {
		service.deleteSubjectByID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data deleted succesfully");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@GetMapping(EndPoints.SubjectEndPoints.getSubjectById)
	@Operation(summary = "Get Subject details by ID", description = "To retrieve details of the Subject by their ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Subject retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Subject not found") })
	public ResponseEntity<ResponseStructure<SubjectDto>> getSubjectByID(@PathVariable int id) {
		SubjectDto subjectByID = service.getSubjectByID(id);
		ResponseStructure<SubjectDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), subjectByID);
		return new ResponseEntity<ResponseStructure<SubjectDto>>(structure, HttpStatus.OK);
	}

	@GetMapping(EndPoints.SubjectEndPoints.getAllSubjectByClassID)
	@Operation(summary = "Get Subjects by Class ID", description = "To retrieve a list of Subjects by the Class ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Subjects retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Class not found") })
	public ResponseEntity<ResponseStructure<List<SubjectDto>>> getSubjectsByClassID(@PathVariable int id) {
		List<SubjectDto> list = service.getSubjectsByClassID(id);
		ResponseStructure<List<SubjectDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), list);
		return new ResponseEntity<ResponseStructure<List<SubjectDto>>>(structure, HttpStatus.OK);
	}

}
