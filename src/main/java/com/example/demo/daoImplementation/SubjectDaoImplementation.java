package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Subject;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositry.SubjectRepositry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SubjectDaoImplementation implements SubjectDao {

	@Autowired
	private SubjectRepositry repository;

	@Autowired
	private ClassDao c_dao;

	@Override
	public Subject saveSubject(Subject s, int class_id) {
		try {
			checkIfCodeExists(s.getCode());
			boolean existsByNameAndClassId = repository.existsByNameAndClassId(s.getName(), class_id);
			if (existsByNameAndClassId) {
				throw new ResourceAlreadyExistsException("Subject " + s.getName() + " already exists for this Class");
			}

			Class classByID = c_dao.getClassByID(class_id);
			s.setClass_ref(classByID);

			return repository.save(s);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Saving the Subject. Please try again later");
		}

	}

	@Override
	public Subject updateSubject(Subject s) {
		try {

			checkIfIdExists(s.getId());

			Subject prev_Subject = repository.findById(s.getId()).get();

			boolean exists = repository.existsByCodeAndNotId(s.getCode(), s.getId());

			if (exists) {
				throw new ResourceAlreadyExistsException("Subject already Exists By Code: " + s.getCode());
			}
			
			
			Class class1 = prev_Subject.getClass_ref();
			
			
			exists = repository.existsByNameAndClassRefAndIdNot(class1.getId(), s.getName(),
					s.getId());

			if (exists) {
				throw new ResourceAlreadyExistsException("Subject " + s.getName() + " already exists for this class");
			}

			prev_Subject.setName(s.getName());
			prev_Subject.setCode(s.getCode());
			prev_Subject.setCredits(s.getCredits());

			return repository.save(prev_Subject);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Subject. Please try again later");
		}
	}

	@Override
	public boolean deleteSubjectByID(int id) {
		try {

			checkIfIdExists(id);
			repository.deleteById(id);
			return true;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Subject. Please try again later");
		}
	}

	@Override
	public Subject getSubjectByID(int id) {
		try {
			checkIfIdExists(id);
			return repository.findById(id).get();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Subject. Please try again later");
		}
	}

	@Override
	public List<Subject> getSubjectsByClassID(int id) {
		try {
			c_dao.checkIfIdExists(id);

			List<Subject> list = repository.findSubjectsByClassId(id);
			return list;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Subject. Please try again later");
		}
	}

	@Override
	public void checkIfCodeExists(String code) {
		boolean existsByCode = repository.existsByCode(code);
		if (existsByCode) {
			throw new ResourceAlreadyExistsException("Subject already Exists By Code: " + code);
		}
	}

	@Override
	public void checkIfIdExists(int id) {
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new ResourceNotFoundException("Subject Not Found with ID: " + id);
		}
	}

}
