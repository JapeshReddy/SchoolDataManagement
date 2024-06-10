package com.example.demo.serviceImplemantation;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Class;
import com.example.demo.entity.Marks;
import com.example.demo.entity.Section;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	@Transactional
	public StudentDto saveStudent(Student s, int section_id) {
		Student student = dao.saveStudent(s, section_id);
		return convertIntoDto(student);
	}

	@Override
	@Transactional
	public StudentDto updateStudent(Student s, int id) {
		s.setId(id);
		Student student = dao.updateStudent(s);

		return convertIntoDto(student);
	}

	@Override
	public StudentDto getStudentByID(int id) {
		Student student = dao.getStudentByID(id);
		return convertIntoDto(student);
	}

	@Override
	public List<StudentDto> getAllStudentsByClass(int id) {
		List<Student> list = dao.getAllStudentsByClass(id);
		return list.stream().map((student) -> convertIntoDto(student)).toList();
	}

	@Override
	public List<StudentDto> getAllStudentsByClassAndSection(int section_id) {
		List<Student> list = dao.getAllStudentsByClassAndSection(section_id);
		return list.stream().map((student) -> convertIntoDto(student)).toList();
	}

	@Override
	public boolean deleteStudentByID(int id) {
		boolean b = dao.deleteStudentByID(id);
		return b;
	}

	private static StudentDto convertIntoDto(Student student) {
		StudentDto dto = new StudentDto(student);
		Section section = student.getSection_ref();
		dto.setSectionName(section.getName());
		Class ref = section.getClass_ref();
		dto.setAcademicTear(ref.getAcademicYear());
		dto.setClassName(ref.getName());

		LinkedHashMap<String, Byte> map = new LinkedHashMap<>();
		List<Marks> list = student.getMarks();

		if (list != null) {
			list.forEach((marks) -> {
				map.put(marks.getSubject_ref().getName(), marks.getMarks());
			});
		}
		dto.setMarks(map);
		return dto;

	}

}
