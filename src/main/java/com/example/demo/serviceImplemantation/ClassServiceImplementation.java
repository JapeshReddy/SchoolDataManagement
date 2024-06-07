package com.example.demo.serviceImplemantation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Class;
import com.example.demo.service.ClassService;



@Service
public class ClassServiceImplementation implements ClassService {

	@Override
	public Class saveClass(Class c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class updateClass(Class c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteClassByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class getClassByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class> getAllClassDetailsByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

}
