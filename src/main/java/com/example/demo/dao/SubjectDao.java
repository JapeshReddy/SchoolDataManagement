package com.example.demo.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Subject;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface SubjectDao {

	Subject saveSubject(Subject s, int class_id);

	Subject updateSubject(Subject s);

	boolean deleteSubjectByID(int id);

	Subject getSubjectByID(@PathVariable int id);

	List<Subject> getSubjectsByClassID(int id);
}
