package com.example.demo.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Section;

public interface SectionDao {

	Section saveSection(Section s, int class_id);

	Section updateSection(Section s);

	boolean deleteSectionByID(int id);

	Section getSectionByID(@PathVariable int id);

	List<Section> getAllSectionDetailsByClassId(int class_id);

	boolean existsSectionByID(int id);

	

	void updateBoysCountByOne(Section section, boolean increment);

	void updateGirlsCountByOne(Section section, boolean increment);
}
