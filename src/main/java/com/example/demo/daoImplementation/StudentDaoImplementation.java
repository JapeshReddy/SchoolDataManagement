package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.SectionDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Section;
import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositry.StudentRepositry;

@Repository
public class StudentDaoImplementation implements StudentDao {

	@Autowired
	private StudentRepositry repository;

	@Autowired
	private ClassDao c_dao;
	
	@Autowired
	private SectionDao sec_dao;

	@Override
	public Student saveStudent(Student s, int sec_id) {
		try {

			Section sc = sec_dao.getSectionByID(sec_id);
			existsByEmail(s.getEmail());
			s.setSection_ref(sc);
			Student student = repository.save(s);

			return student;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Saving the Student. Please try again later");
		}
	}

	@Override
	public Student updateStudent(Student s) {
		try {
			existsById(s.getId());
			boolean exists = repository.existsByEmailAndIdNot(s.getEmail(), s.getId());
			if (exists) {
				throw new ResourceAlreadyExistsException("Student already exists with Email: " + s.getEmail());
			}
			
			System.out.println(s.getAddress());
			
			Student student = getStudentByID(s.getId());
			student.setName(s.getName());
			student.setAddress(s.getAddress());
			student.setDob(s.getDob());
			student.setEmail(s.getEmail());
			student.setPhoneNo(s.getPhoneNo());
			student.setMarks(s.getMarks());
			student.setGender(s.getGender());
			return repository.save(student);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Updating the Student. Please try again later");
		}

	}

	@Override
	public boolean deleteStudentByID(int id) {
		try {
			Student student = getStudentByID(id);

			repository.delete(student);

			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Deleting the Student. Please try again later");
		}
	}

	@Override
	public Student getStudentByID(int id) {
		try {
			return repository.findById(id)
					.orElseThrow(() -> new ResourceAlreadyExistsException("Student not exists with ID: " + id));
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Student. Please try again later");
		}
	}

	@Override
	public List<Student> getAllStudentsByClass(int id) {
		try {
			Class classByID = c_dao.getClassByID(id);
			List<Student> studentList = classByID.getSections().stream().flatMap((sec) -> sec.getStudents().stream())
					.toList();
			if (studentList.isEmpty())
				throw new ResourceNotFoundException("Students not present in that Class with id: " + id);
			return studentList;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Student. Please try again later");
		}

	}

	@Override
	public List<Student> getAllStudentsByClassAndSection(int section_id) {
		try {
			Section section = sec_dao.getSectionByID(section_id);
			List<Student> list = section.getStudents().stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
					.toList();
			if (list.isEmpty()) {
				throw new ResourceNotFoundException("No students found for the provided class ID ");
			}
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Student. Please try again later");
		}
	}

	@Override
	public boolean existsById(int id) {
		try {
			boolean b = repository.existsById(id);
			if (!b) {
				throw new ResourceNotFoundException("Student not exists with ID: " + id);
			}
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Student. Please try again later");
		}
	}

	@Override
	public boolean existsByEmail(String email) {
		try {
			boolean b = repository.existsByEmail(email);
			if (b) {
				throw new ResourceAlreadyExistsException("Student already exists with Email: " + email);
			}
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while Fetching the Student. Please try again later");
		}
	}

}
