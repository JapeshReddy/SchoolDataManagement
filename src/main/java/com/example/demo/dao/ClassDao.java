package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Class;

public interface ClassDao {

	Class saveClass(Class c);

	boolean updateClass(Class c);

	boolean deleteClassByID(int id);

	Class getClassByID(int id);

	List<Class> getAllClassDetailsByYear(int year);
}
