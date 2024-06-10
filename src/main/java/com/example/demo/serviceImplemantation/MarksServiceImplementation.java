package com.example.demo.serviceImplemantation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MarksDao;
import com.example.demo.dto.MarksDto;
import com.example.demo.entity.Marks;
import com.example.demo.service.MarksService;

@Service
public class MarksServiceImplementation implements MarksService {

	@Autowired
	private MarksDao dao;

	@Transactional
	@Override
	public MarksDto saveMarks(Marks s, int student_id, int subject_id) {
		Marks marks = dao.saveMarks(s, student_id, subject_id);

		return convertIntoDto(marks);
	}

	@Transactional
	@Override
	public MarksDto updateMarks(Marks s, int id) {
		Marks marks = dao.updateMarks(s, id);
		return convertIntoDto(marks);
	}
	@Transactional
	@Override
	public boolean deleteMarksByID(int id) {
		boolean b = dao.deleteMarksByID(id);
		return b;
	}
	@Transactional
	@Override
	public boolean deleteMarksByStudentID(int student_id) {
		return dao.deleteMarksByStudentID(student_id);
	}
	@Transactional
	@Override
	public boolean deleteMarksBySubjectID(int subject_id) {
		return dao.deleteMarksBySubjectID(subject_id);
	}

	@Override
	public MarksDto getMarksByID(int id) {
		Marks marks = dao.getMarksByID(id);
		return convertIntoDto(marks);
	}

	@Override
	public List<MarksDto> getMarksByStudentID(int student_id) {
		List<Marks> list = dao.getMarksByStudentID(student_id);
		ArrayList<MarksDto> dtObjects = new ArrayList<>();
		if (!list.isEmpty()) {
			list.forEach((marks) -> dtObjects.add(convertIntoDto(marks)));
		}
		return dtObjects;
	}

	@Override
	public List<MarksDto> getMarksBySubjectId(int subject_id) {
		List<Marks> list = dao.getMarksBySubjectId(subject_id);
		ArrayList<MarksDto> dtObjects = new ArrayList<>();
		if (!list.isEmpty()) {
			list.forEach((marks) -> dtObjects.add(convertIntoDto(marks)));
		}
		return dtObjects;
	}

	private MarksDto convertIntoDto(Marks marks) {
		MarksDto dto = new MarksDto(marks);
		dto.setCredits(marks.getSubject_ref().getCredits());
		dto.setStudentName(marks.getStudent_ref().getName());
		dto.setSubjectCode(marks.getSubject_ref().getCode());
		dto.setSubjectName(marks.getSubject_ref().getName());

		return dto;
	}

}
