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
import com.example.demo.dto.SectionDto;
import com.example.demo.entity.ResponseStructure;
import com.example.demo.entity.Section;
import com.example.demo.service.SectionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndPoints.SectionEndPoints.baseUrl)
@Tag(name = "2. Section Controller", description = "To perform CRUD operations on the Section")
public class SectionController {

	@Autowired
	private SectionService service;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Save new Section of a Class", description = "To save section details of a class in the database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Section created"),
			@ApiResponse(responseCode = "409", description = "Section already exists") })
	public ResponseEntity<ResponseStructure<SectionDto>> saveSection(@RequestBody Section s,
			@RequestParam int class_id) {
		SectionDto dto = service.saveSection(s, class_id);
		ResponseStructure<SectionDto> structure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Created",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<SectionDto>>(structure, HttpStatus.CREATED);
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update an existing Section of a Class", description = "To update the details of an existing section")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Section updated"),
			@ApiResponse(responseCode = "404", description = "Section not found") })
	public ResponseEntity<ResponseStructure<SectionDto>> updateSection(@RequestBody Section s, @RequestParam int id) {
		SectionDto dto = service.updateSection(s, id);
		ResponseStructure<SectionDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<SectionDto>>(structure, HttpStatus.OK);
	}

	@DeleteMapping(EndPoints.SectionEndPoints.deleteSectionByID)
	@Operation(summary = "Delete an existing Section of a Class", description = "To delete the details of section by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Section deleted"),
			@ApiResponse(responseCode = "404", description = "Section not found") })
	public ResponseEntity<ResponseStructure<String>> deleteSectionByID(@PathVariable int id) {
		service.deleteSectionByID(id);
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), "Data deleted Succesfully");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.SectionEndPoints.getSectionById, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get Section details by ID", description = "To retrieve details of the section by their ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Section fetched"),
			@ApiResponse(responseCode = "404", description = "Section not found") })
	public ResponseEntity<ResponseStructure<SectionDto>> getSectionByID(@PathVariable int id) {
		SectionDto dto = service.getSectionByID(id);
		ResponseStructure<SectionDto> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), dto);
		return new ResponseEntity<ResponseStructure<SectionDto>>(structure, HttpStatus.OK);
	}

	@GetMapping(value = EndPoints.SectionEndPoints.getAllSectionByClassID, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get all Sections of a Class", description = "To retrieve a list of section details by class ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "All sections fetched"),
			@ApiResponse(responseCode = "404", description = "No existing sections for that class ID") })
	public ResponseEntity<ResponseStructure<List<SectionDto>>> getAllSectionDetailsByClassId(@RequestParam int id) {
		List<SectionDto> list = service.getAllSectionDetailsByClassId(id);

		ResponseStructure<List<SectionDto>> structure = new ResponseStructure<>(HttpStatus.OK.value(), "Success",
				LocalDateTime.now(), list);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
