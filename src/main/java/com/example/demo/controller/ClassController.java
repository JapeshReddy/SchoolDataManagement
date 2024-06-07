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
import com.example.demo.entity.Class;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.exception.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(EndPoints.ClassEndPoints.baseUrl)
@Tag(name = "Class Controller", description = "To perform CRUD operations on the Class")
public class ClassController {

	@PostMapping
	@Operation(summary = "Save new Class ", description = "To Save  Class details in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Class>> saveClass(@RequestBody Class s) {
		return null;
	}

	@PutMapping
	@Operation(summary = "Update's an existing Class", description = "To Update the details of an existing Class ")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> updateClass(@RequestBody Class s) {
		return null;
	}

	@DeleteMapping(EndPoints.ClassEndPoints.deleteClassByID)
	@Operation(summary = "Delete's an existing data", description = "To delete the details of Class by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteClassByID(@PathVariable int id) {
		log.debug("delete method debug");
		log.trace("delete method trace");
		log.warn("delete method warn");
		log.info("delete method info");
		log.error("Error log", id);
		log.fatal("Error log", id);
		log.error("Error log", id);
		return null;
	}

	@GetMapping(EndPoints.ClassEndPoints.getClassById)
	@Operation(summary = "Get Class details by ID", description = "To Retrieve details of the student by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Class>> getClassByID(@PathVariable int id) {
		throw new ResourceNotFoundException("Object with ID not exists");

	}

	@GetMapping
	@Operation(summary = "Get all Class details of a  year", description = "Retrieve a list of Class details based on the year")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<List<Class>>> getAllClassDetails(@RequestParam int academic_year) {
		return null;
	}

}
