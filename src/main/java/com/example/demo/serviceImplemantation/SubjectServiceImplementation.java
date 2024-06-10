package com.example.demo.serviceImplemantation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SubjectDao;
import com.example.demo.dto.SubjectDto;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;

@Service
public class SubjectServiceImplementation implements SubjectService {

	@Autowired
	private SubjectDao dao;

	@Override
	@Transactional
	public SubjectDto saveSubject(Subject s, int class_id) {
		Subject subject = dao.saveSubject(s, class_id);
		return convertIntoDto(subject);
	}

	@Override
	@Transactional
	public SubjectDto updateSubject(Subject s, int id) {
		s.setId(id);
		Subject subject = dao.updateSubject(s);
		return convertIntoDto(subject);
	}

	@Override
	@Transactional
	public boolean deleteSubjectByID(int id) {
		return dao.deleteSubjectByID(id);
	}

	@Override
	public SubjectDto getSubjectByID(int id) {
		Subject subject = dao.getSubjectByID(id);
		return convertIntoDto(subject);
	}

	@Override
	public List<SubjectDto> getSubjectsByClassID(int id) {
		List<Subject> list = dao.getSubjectsByClassID(id);
		ArrayList<SubjectDto> dto = new ArrayList<>();
		if (!list.isEmpty()) {
			list.forEach((subject) -> {
				dto.add(convertIntoDto(subject));
			});
		}
		return dto;
	}

	private SubjectDto convertIntoDto(Subject s) {
		SubjectDto dto = new SubjectDto(s);
		dto.setClassName(s.getClass_ref().getName());
		return dto;
	}

}
