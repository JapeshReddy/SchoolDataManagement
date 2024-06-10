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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.EndPoints;
import com.example.demo.dto.ClassDto;
import com.example.demo.entity.Class;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.service.ClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndPoints.ClassEndPoints.baseUrl)
@Tag(name = "1. Class Controller", description = "To perform CRUD operations on the Class")
public class ClassController {

	@Autowired
	private ClassService service;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Save new Class", description = "To save class details in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Class created"),
			@ApiResponse(responseCode = "409", description = "Class already exists") })
	public ResponseEntity<ResponseStructure<ClassDto>> saveClass(@RequestBody Class s) {
		ClassDto dto = service.saveClass(s);
		ResponseStructure<ClassDto> structure = new ResponseStructure<>(HttpStatus.CREATED.value(), "created",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<ClassDto>>(structure, HttpStatus.CREATED);
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update an existing Class", description = "To update the details of an existing Class")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Class updated"),
			@ApiResponse(responseCode = "404", description = "Class not found") })
	public ResponseEntity<ResponseStructure<ClassDto>> updateClass(@RequestBody Class s, @RequestParam int id) {

		ClassDto dto = service.updateClass(s, id);
		ResponseStructure<ClassDto> structure = new ResponseStructure<ClassDto>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@DeleteMapping(value = EndPoints.ClassEndPoints.deleteClassByID)
	@Operation(summary = "Delete an existing Class", description = "To delete the details of Class by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Class deleted"),
			@ApiResponse(responseCode = "404", description = "Class not found") })
	public ResponseEntity<ResponseStructure<String>> deleteClassByID(@PathVariable int id) {
		service.deleteClassByID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data Deleted Succesfully");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.ClassEndPoints.getClassById, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get Class details by ID", description = "To retrieve details of the Class by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Class fetched"),
			@ApiResponse(responseCode = "404", description = "Class not found") })
	public ResponseEntity<ResponseStructure<ClassDto>> getClassByID(@PathVariable int id) {
		ClassDto dto = service.getClassByID(id);
		ResponseStructure<ClassDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get all Class details of a year", description = "Retrieve a list of Class details based on the year")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "All classes fetched"),
			@ApiResponse(responseCode = "404", description = "No existing classes in that year") })
	public ResponseEntity<ResponseStructure<List<ClassDto>>> getAllClassDetails(@RequestParam int academic_year) {
		List<ClassDto> list = service.getAllClassDetailsByYear(academic_year);
		ResponseStructure<List<ClassDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), list);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
