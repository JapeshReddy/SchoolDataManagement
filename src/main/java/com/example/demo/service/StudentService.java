package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;

public interface StudentService {

	StudentDto saveStudent(Student s, int section_id);

	StudentDto updateStudent(Student s, int id);

	StudentDto getStudentByID(int id);

	List<StudentDto> getAllStudentsByClassAndSection( int section_id);

	List<StudentDto> getAllStudentsByClass(int id);

	boolean deleteStudentByID(int id);

}
