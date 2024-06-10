package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDao {

	Student updateStudent(Student s);

	boolean deleteStudentByID(int id);

	Student getStudentByID(int id);

	boolean existsById(int id);

	boolean existsByEmail(String email);


	List<Student> getAllStudentsByClass(int id);

	Student saveStudent(Student s, int sec_id);

	List<Student> getAllStudentsByClassAndSection(int section_id);
}
