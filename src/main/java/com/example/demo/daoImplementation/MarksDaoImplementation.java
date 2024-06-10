package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MarksDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Marks;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.StudentAndSubjectNotInSameClassException;
import com.example.demo.repositry.MarksRepositry;

@Repository
public class MarksDaoImplementation implements MarksDao {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private MarksRepositry repository;

	@Override
	public Marks saveMarks(Marks s, int student_id, int subject_id) {
		try {
			Subject subject = subjectDao.getSubjectByID(subject_id);
			Student student = studentDao.getStudentByID(student_id);

			boolean exists = repository.existsByStudentIdAndSubjectId(student_id, subject_id);
			if (exists) {
				throw new ResourceAlreadyExistsException("Marks for this Subject is already present for this student");
			}

			boolean belongs = repository.doStudentAndSubjectBelongToSameClass(student_id, subject_id);
			if (!belongs) {
				throw new StudentAndSubjectNotInSameClassException(
						"The student and subject do not belong to the same class.");
			}
			s.setStudent_ref(student);
			s.setSubject_ref(subject);

			return repository.save(s);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Saving the Marks. Please try again later");

		}
	}

	@Override
	public Marks updateMarks(Marks s, int id) {
		try {
			checkIdExists(id);

			Marks prevMarks = repository.findById(id).get();
			prevMarks.setExamDate(s.getExamDate());
			prevMarks.setMarks(s.getMarks());

			return repository.save(prevMarks);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Updating the Marks. Please try again later");
		}
	}

	@Override
	public boolean deleteMarksByID(int id) {
		try {
			checkIdExists(id);
			repository.deleteById(id);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Marks. Please try again later");
		}
	}

	@Override
	public boolean deleteMarksByStudentID(int student_id) {
		try {
			studentDao.existsById(student_id);
			repository.deleteMarksByStudentId(student_id);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Marks. Please try again later");
		}
	}

	@Override
	public boolean deleteMarksBySubjectID(int subject_id) {
		try {
			subjectDao.checkIfIdExists(subject_id);
			repository.deleteBySubjectId(subject_id);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Marks. Please try again later");
		}
	}

	@Override
	public Marks getMarksByID(int id) {
		try {
			checkIdExists(id);
			return repository.findById(id).get();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Marks. Please try again later");
		}
	}

	@Override
	public List<Marks> getMarksByStudentID(int student_id) {
		try {
			studentDao.existsById(student_id);

			List<Marks> list = repository.findMarksByStudentId(student_id);
			return list;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Marks. Please try again later");
		}
	}

	@Override
	public List<Marks> getMarksBySubjectId(int subject_id) {
		try {
			subjectDao.checkIfIdExists(subject_id);

			List<Marks> list = repository.findMarksBySubjectId(subject_id);
			return list;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Marks. Please try again later");
		}
	}

	private void checkIdExists(int id) {
		boolean exists = repository.existsById(id);
		if (exists) {
			throw new ResourceNotFoundException("Marks not exists for this ID: " + id);
		}
	}

}
