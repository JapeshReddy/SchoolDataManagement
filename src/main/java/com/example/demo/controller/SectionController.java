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

import com.example.demo.entity.ResponseStructure;
import com.example.demo.configuration.EndPoints;
import com.example.demo.entity.Section;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(EndPoints.SectionEndPoints.baseUrl)
@Tag(name = "Section Controller",description = "To perform CRUD operations on the Section")
public class SectionController {

	@PostMapping
	@Operation(summary = "Save new Section of a Class", description = "To Save  Section details of a Class  in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Section>> saveSection(@RequestBody Section s,@RequestParam int class_id) {
		return null;
	}

	@PutMapping
	@Operation(summary = "Update's an existing Section of a Class", description = "To Update the details of an existing Section ")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> updateSection(@RequestBody Section s) {
		return null;
	}

	@DeleteMapping(EndPoints.SectionEndPoints.deleteSectionByID)
	@Operation(summary = "Delete's an existing Section of a Class", description = "To delete the details of Section by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<String>> deleteSectionByID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.SectionEndPoints.getSectionById)
	@Operation(summary = "Get Section details by ID", description = "To Retrieve details of the student by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<Section>> getSectionByID(@PathVariable int id) {
		return null;
	}

	@GetMapping(EndPoints.SectionEndPoints.getAllSectionByClassID)
	@Operation(summary = "Get all Sections of a Class", description = "To Retrieve a list of Section details of a Class_Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "203", description = ""),
			@ApiResponse(responseCode = "", description = "") })
	public ResponseEntity<ResponseStructure<List<Section>>> getAllSectionDetailsByClassId(@RequestParam int id) {
		return null;
	}


}
