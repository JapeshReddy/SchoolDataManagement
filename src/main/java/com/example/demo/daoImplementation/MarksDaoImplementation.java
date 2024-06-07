package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.MarksDao;
import com.example.demo.entity.Marks;


@Repository
public class MarksDaoImplementation implements MarksDao {

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
