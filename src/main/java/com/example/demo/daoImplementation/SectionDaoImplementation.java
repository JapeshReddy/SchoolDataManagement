package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.SectionDao;
import com.example.demo.entity.Section;


@Repository
public class SectionDaoImplementation implements SectionDao {

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
