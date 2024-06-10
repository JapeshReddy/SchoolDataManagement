package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MarksDto;
import com.example.demo.entity.Marks;

public interface MarksService {

	MarksDto saveMarks(Marks s, int student_id, int subject_id);

	MarksDto updateMarks(Marks s, int id);

	boolean deleteMarksByID(int id);

	boolean deleteMarksByStudentID(int student_id);

	boolean deleteMarksBySubjectID(int subject_id);

	MarksDto getMarksByID(int id);

	List<MarksDto> getMarksByStudentID(int student_id);

	List<MarksDto> getMarksBySubjectId(int subject_id);

}
