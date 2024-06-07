package com.example.demo.serviceImplemantation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@Service
public class StudentServiceImplementation implements StudentService {

	@Override
	public Student saveStudent(Student s, int section_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudentByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsByClass(int id, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsByClassAndSection(int class_id, int section_id, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
