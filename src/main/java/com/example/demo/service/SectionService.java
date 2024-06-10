package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SectionDto;
import com.example.demo.entity.Section;

public interface SectionService {

	SectionDto saveSection(Section s, int class_id);


	boolean deleteSectionByID(int id);

	SectionDto getSectionByID(int id);

	List<SectionDto> getAllSectionDetailsByClassId(int class_id);

	SectionDto updateSection(Section s, int id);
}
