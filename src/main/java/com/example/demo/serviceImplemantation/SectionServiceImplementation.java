package com.example.demo.serviceImplemantation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Section;
import com.example.demo.service.SectionService;


@Service
public class SectionServiceImplementation implements SectionService {

	@Override
	public Section saveSection(Section s, int class_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section updateSection(Section s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSectionByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Section getSectionByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Section> getAllSectionDetailsByClassId(int class_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
