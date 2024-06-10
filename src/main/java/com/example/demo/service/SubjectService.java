package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.SubjectDto;
import com.example.demo.entity.Subject;

public interface SubjectService {

	SubjectDto saveSubject(Subject s, int class_id);


	boolean deleteSubjectByID(int id);

	SubjectDto getSubjectByID(@PathVariable int id);

	List<SubjectDto> getSubjectsByClassID(int id);

	SubjectDto updateSubject(Subject s, int id);

}
