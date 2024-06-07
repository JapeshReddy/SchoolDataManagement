package com.example.demo.controller;

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
import com.example.demo.entity.Marks;
import com.example.demo.entity.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(EndPoints.MarksEndPoints.baseUrl)
@Tag(name = "Marks Controller",description = "To perform CRUD operations on the Student Marks")
public class MarksController {

	@PostMapping
	@Operation(summary = "Save new Marks Of Student ", description = "To Save new  Marks details of a Subject for existing Student in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Marks>> saveMarks(@RequestBody Marks s,@RequestParam int student_id,@RequestParam int subject_id) {
		return null;
	}

	@PutMapping
	@Operation(summary = "Update's an existing Marks", description = "To Update the details of an existing Marks in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> updateMarks(@RequestBody Marks s,int id) {
		return null;
	}

	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksByID)
	@Operation(summary = "Delete's an existing Marks", description = "To delete the details of Marks by ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksByID(@PathVariable int id) {
		return null;
	}
	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksByStudentID)
	@Operation(summary = "Delete's all Marks of an Student", description = "To delete the all Marks Of an  by Student_ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksByStudnetID(@PathVariable int id) {
		return null;
	}
	@DeleteMapping(EndPoints.MarksEndPoints.deleteMarksBySubjectID)
	@Operation(summary = "Delete's all Marks of an Student", description = "To delete the all Marks Of an  by Student_ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteMarksBySubjectID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.MarksEndPoints.getMarksById)
	@Operation(summary = "Get Marks details by ID", description = "To Retrieve details of the Marks by their ID in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Marks>> getMarksByID(@PathVariable int id) {
		return null;
	}
	@GetMapping(EndPoints.MarksEndPoints.getMarksByStudentId)
	@Operation(summary = "Get Marks details by ID", description = "To Retrieve List of the Marks by the Student_ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Marks>> getMarksByStudentID(@PathVariable int id) {
		return null;
	}
	@GetMapping(EndPoints.MarksEndPoints.getMarksBySubjectId)
	@Operation(summary = "Get Marks details by Subject_ID", description = "To Retrieve List of Marks by their Subject_ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Marks>> getMarksBySubjectId(@PathVariable int id) {
		return null;
	}

	


}
