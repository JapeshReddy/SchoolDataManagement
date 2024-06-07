package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Marks;

public class MarksService {

	Marks saveMarks(Marks s, int student_id, int subject_id);

	Marks updateMarks(Marks s, int id);

	boolean deleteMarksByID(int id);

	boolean deleteMarksByStudentID(int student_id);

	boolean deleteMarksBySubjectID(int subject_id);

	Marks getMarksByID(int id);

	List<Marks> getMarksByStudentID(int student_id);

	List<Marks> getMarksBySubjectId(int subject_id);

}
