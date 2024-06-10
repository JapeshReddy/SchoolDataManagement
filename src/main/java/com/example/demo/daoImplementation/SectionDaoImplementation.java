package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.SectionDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Section;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositry.SectionRepositry;

@Repository
public class SectionDaoImplementation implements SectionDao {

	@Autowired
	private SectionRepositry repository;
	@Autowired
	private ClassDao classDao;

	@Override
	public Section saveSection(Section s, int class_id) {
		try {
			boolean b = repository.existsByRoomNumber(s.getRoomNumber());
			if (b) {
				throw new ResourceAlreadyExistsException("Section already exists in Room Number " + s.getRoomNumber());
			}

			Class classByID = classDao.getClassByID(class_id);
			b = repository.existsByNameAndClassRef(s.getName(), classByID);
			if (b) {
				throw new ResourceAlreadyExistsException(
						"Section already exists with  Name " + s.getName() + " for the Class ");
			}

			s.setClass_ref(classByID);

			Section section = repository.save(s);
			return section;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Saving the Section. Please try again later");
		}
	}

	@Override
	public Section updateSection(Section s) {

		try {
			existsSectionByID(s.getId());
			Section prevSection = repository.findById(s.getId()).get();

			List<Section> list = repository.findByRoomNumberAndIdNot(s.getRoomNumber(), s.getId());
			if (list.size() != 0) {
				throw new ResourceAlreadyExistsException("Section already exists in Room Number " + s.getRoomNumber());
			}
			Class classByID = prevSection.getClass_ref();
			boolean b = repository.existsByNameAndClassRefAndIdNot(s.getName(), classByID, s.getId());
			if (b) {
				throw new ResourceAlreadyExistsException(
						"Section already exists with  Name " + s.getName() + " for the Class ");
			}

			prevSection.setRoomNumber(s.getRoomNumber());
			prevSection.setName(s.getName());

			return repository.save(prevSection);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Updating the Section. Please try again later");
		}
	}

	@Override
	public boolean deleteSectionByID(int id) {

		try {

			existsSectionByID(id);
			Section section = repository.findById(id).get();
			repository.delete(section);
			return true;

		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Deleting the Section. Please try again later");
		}
	}

	@Override
	public Section getSectionByID(int id) {
		try {

			existsSectionByID(id);
			return repository.findById(id).get();

		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Section. Please try again later");
		}
	}

	@Override
	public boolean existsSectionByID(int id) {
		try {

			boolean exists = repository.existsById(id);
			if (!exists) {
				throw new ResourceNotFoundException("No Section for the ID: " + id);
			}
			return true;

		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Section. Please try again later");
		}
	}

	@Override
	public List<Section> getAllSectionDetailsByClassId(int class_id) {
		try {

			Class classByID = classDao.getClassByID(class_id);

			return classByID.getSections();

		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Sections. Please try again later");
		}
	}

	@Override
	public void updateBoysCountByOne(Section section, boolean increment) {
		try {
			short boysCount = section.getBoysCount();
			boysCount = increment ? (short) (boysCount + 1) : (short) (boysCount - 1);
			section.setBoysCount(boysCount);
			repository.save(section);
		} catch (DataAccessException e) {
			String operation = increment ? "increasing" : "decreasing";
			throw new RuntimeException(
					"An error occurred while " + operation + " the count of boys. Please try again later");
		}
	}

	@Override
	public void updateGirlsCountByOne(Section section, boolean increment) {
		try {
			short girlsCount = section.getGirlsCount();
			girlsCount = increment ? (short) (girlsCount + 1) : (short) (girlsCount - 1);
			section.setGirlsCount(girlsCount);
			repository.save(section);
		} catch (DataAccessException e) {
			String operation = increment ? "increasing" : "decreasing";
			throw new RuntimeException(
					"An error occurred while " + operation + " the count of girls. Please try again later");
		}
	}

}
