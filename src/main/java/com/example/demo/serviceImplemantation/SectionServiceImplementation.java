package com.example.demo.serviceImplemantation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SectionDao;
import com.example.demo.dto.SectionDto;
import com.example.demo.entity.Class;
import com.example.demo.entity.Section;
import com.example.demo.service.SectionService;

@Service
public class SectionServiceImplementation implements SectionService {

	@Autowired
	private SectionDao dao;

	@Override
	@Transactional
	public SectionDto saveSection(Section s, int class_id) {
		Section section = dao.saveSection(s, class_id);
		return convertIntoDto(section);
	}

	@Override
	@Transactional
	public SectionDto updateSection(Section s, int id) {
		s.setId(id);
		Section section = dao.updateSection(s);
		return convertIntoDto(section);
	}

	@Override
	@Transactional
	public boolean deleteSectionByID(int id) {
		return dao.deleteSectionByID(id);

	}

	@Override
	public SectionDto getSectionByID(int id) {
		Section section = dao.getSectionByID(id);
		return convertIntoDto(section);
	}

	@Override
	public List<SectionDto> getAllSectionDetailsByClassId(int class_id) {
		List<Section> list = dao.getAllSectionDetailsByClassId(class_id);
		ArrayList<SectionDto> list2 = new ArrayList<>();
		list.forEach((e) -> list2.add(convertIntoDto(e)));

		return list2.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).toList();
	}

	private static SectionDto convertIntoDto(Section c) {
		Class class_ref = c.getClass_ref();

		return new SectionDto(c.getId(), c.getName(), c.getRoomNumber(), c.getBoysCount(), c.getGirlsCount(),
				class_ref.getName(), class_ref.getAcademicYear());
	}

}
