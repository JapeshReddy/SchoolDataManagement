package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Class;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositry.ClassRepositry;

@Repository
public class ClassDaoImplementation implements ClassDao {

	@Autowired
	private ClassRepositry repository;

	@Override
	public Class saveClass(Class c) {

		try {
			boolean flag = repository.existsByNameAndAcademicYear(c.getName(), c.getAcademicYear());
			if (flag) {
				throw new ResourceAlreadyExistsException("Class already exists with the Name " + c.getName()
						+ " and Academic_Year " + c.getAcademicYear());

			}

			Class save = repository.save(c);
			return save;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while saving the Class. Please try again later");
		}
	}

	@Override
	public Class updateClass(Class c) {
		try {

			checkIfIdExists(c.getId());

			if (repository.existsByNameAndAcademicYearAndIdNot(c.getName(), c.getAcademicYear(), c.getId())) {
				throw new ResourceAlreadyExistsException("Class already exists with the Name " + c.getName()
						+ " and Academic_Year " + c.getAcademicYear());
			}

			Class prevClass = repository.findById(c.getId()).get();
			prevClass.setAcademicYear(c.getAcademicYear());
			prevClass.setName(c.getName());

			return repository.save(prevClass);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Updating the Class. Please try again later");
		}
	}

	@Override
	public boolean deleteClassByID(int id) {
		try {
			checkIfIdExists(id);

			repository.deleteById(id);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Class. Please try again later");

		}
	}

	@Override
	public Class getClassByID(int id) {
		try {
			checkIfIdExists(id);
			Optional<Class> optional = repository.findById(id);
			System.out.println(optional.isPresent());
			return optional.get();
		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Class. Please try again later");
		}
	}

	@Override
	public List<Class> getAllClassDetailsByYear(int year) {
		try {
			List<Class> list = repository.findByAcademicYear(year);
			if (list.isEmpty() || list == null) {
				throw new ResourceNotFoundException("No Classes found for the Accedemic_Year: " + year);
			}
			return list;
		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Class. Please try again later");
		}
	}

	@Override
	public boolean checkIfIdExists(int id) {
		try {
			boolean b = repository.existsById(id);
			if (!b) {
				throw new ResourceNotFoundException("No Class found for the ID :" + id);
			}
			return true;
		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Class. Please try again later");
		}
	}

	@Override
	public boolean existsClassByYear(int year) {
		try {
			boolean b = repository.existsByAcademicYear(year);
			if (!b) {
				new ResourceNotFoundException("No class found for the academic year: " + year);
			}
			return true;
		} catch (DataAccessException e) {
			throw new RuntimeException("An error occurred while Fetching the Class. Please try again later");
		}
	}

	@Override
	public void updateBoysCountByOne(Class clas, boolean increment) {
		try {
			if (increment) {
				repository.incrementBoysCount(clas.getId());
			} else {
				repository.decrementBoysCount(clas.getId());
			}

		} catch (DataAccessException e) {
			String operation = increment ? "increasing" : "decreasing";
			throw new RuntimeException(
					"An error occurred while " + operation + " the count of boys. Please try again later");
		}
	}

	@Override
	public void updateSectionsCountByOne(Class clas, boolean increment) {

		try {
			if (increment) {
				repository.incrementSectionsCount(clas.getId());
			} else {
				repository.decrementSectionsCount(clas.getId());
			}
		} catch (DataAccessException e) {
			String operation = increment ? "increasing" : "decreasing";
			throw new RuntimeException(
					"An error occurred while " + operation + " the sections count. Please try again later");
		}
	}

	@Override
	public void updateGirlsCountByOne(Class clas, boolean increment) {
		try {
			if (increment) {
				repository.incrementGirlsCount(clas.getId());
			} else {
				repository.decrementGirlsCount(clas.getId());
			}
		} catch (DataAccessException e) {
			String operation = increment ? "increasing" : "decreasing";
			throw new RuntimeException(
					"An error occurred while " + operation + " the count of girls. Please try again later");
		}
	}

}
