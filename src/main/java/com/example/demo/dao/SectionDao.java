package com.example.demo.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Section;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface SectionDao {

	Section saveSection( Section s, int class_id);
	
	Section updateSection( Section s);
	
	boolean deleteSectionByID(int id);
	
	Section getSectionByID(@PathVariable int id);
	
	List<Section> getAllSectionDetailsByClassId(int class_id);
}
