package com.example.demo.daoImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Subject;

@Service
public class SubjectDaoImplementation implements SubjectDao {

	@Override
	public Subject saveSubject(Subject s, int class_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject updateSubject(Subject s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSubjectByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Subject getSubjectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> getSubjectsByClassID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
