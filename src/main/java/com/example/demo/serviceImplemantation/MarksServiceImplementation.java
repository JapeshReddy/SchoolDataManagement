package com.example.demo.serviceImplemantation;

import java.util.List;

import com.example.demo.entity.Marks;
import com.example.demo.service.MarksService;

public class MarksServiceImplementation implements MarksService {

	@Override
	public Marks saveMarks(Marks s, int student_id, int subject_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marks updateMarks(Marks s, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMarksByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMarksByStudentID(int student_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMarksBySubjectID(int subject_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Marks getMarksByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marks> getMarksByStudentID(int student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marks> getMarksBySubjectId(int subject_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
