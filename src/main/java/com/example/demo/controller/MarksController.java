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
import com.example.demo.dto.MarksDto;
import com.example.demo.entity.Marks;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.service.MarksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndPoints.MarksEndPoints.baseUrl)
@Tag(name = "5. Marks Controller", description = "To perform CRUD operations on the Student Marks")
public class MarksController {

	@Autowired
	private MarksService service;

	@PostMapping
	@Operation(summary = "Save new Marks of Student", description = "To save new Marks details of a Subject for existing Student in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Marks created successfully"),
			@ApiResponse(responseCode = "409", description = "Marks with the same details already exists") })
	public ResponseEntity<ResponseStructure<MarksDto>> saveMarks(@RequestBody Marks s, @RequestParam int student_id,
			@RequestParam int subject_id) {

		MarksDto dto = service.saveMarks(s, student_id, subject_id);
		ResponseStructure<MarksDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Created",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<MarksDto>>(structure, HttpStatus.CREATED);

	}

	@PutMapping
	@Operation(summary = "Update existing Marks", description = "To update the details of an existing Marks in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Marks updated successfully"),
			@ApiResponse(responseCode = "404", description = "Marks not found") })
	public ResponseEntity<ResponseStructure<MarksDto>> updateMarks(@RequestBody Marks s, int id) {
		MarksDto dto = service.updateMarks(s, id);
		ResponseStructure<MarksDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<MarksDto>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksByID)
	@Operation(summary = "Delete existing Marks", description = "To delete the details of Marks by ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Marks deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Marks not found") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksByID(@PathVariable int id) {
		service.deleteMarksByID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data succesfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksByStudentID)
	@Operation(summary = "Delete all Marks of a Student", description = "To delete all Marks of a Student by Student_ID in the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "All Marks of Student deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksByStudentID(@PathVariable int id) {
		service.deleteMarksByStudentID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data succesfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksBySubjectID)
	@Operation(summary = "Delete all Marks of a Subject", description = "To delete all Marks of a Subject by Subject_ID in the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "All Marks of Subject deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Subject not found") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksBySubjectID(@PathVariable int id) {
		service.deleteMarksBySubjectID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data succesfully deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@GetMapping(EndPoints.MarksEndPoints.getMarksById)
	@Operation(summary = "Get Marks details by ID", description = "To retrieve details of the Marks by their ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Marks not found") })
	public ResponseEntity<ResponseStructure<MarksDto>> getMarksByID(@PathVariable int id) {
		MarksDto dto = service.getMarksByID(id);
		ResponseStructure<MarksDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<MarksDto>>(structure, HttpStatus.OK);
	}

	@GetMapping(EndPoints.MarksEndPoints.getMarksByStudentId)
	@Operation(summary = "Get Marks details by Student ID", description = "To retrieve list of the Marks by the Student_ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<ResponseStructure<List<MarksDto>>> getMarksByStudentID(@PathVariable int id) {
		List<MarksDto> dto = service.getMarksByStudentID(id);
		ResponseStructure<List<MarksDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<List<MarksDto>>>(structure, HttpStatus.OK);
	}

	@GetMapping(EndPoints.MarksEndPoints.getMarksBySubjectId)
	@Operation(summary = "Get Marks details by Subject ID", description = "To retrieve list of Marks by their Subject_ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Subject not found") })
	public ResponseEntity<ResponseStructure<List<MarksDto>>> getMarksBySubjectId(@PathVariable int id) {
		List<MarksDto> dto = service.getMarksBySubjectId(id);
		ResponseStructure<List<MarksDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<List<MarksDto>>>(structure, HttpStatus.OK);
	}

}
