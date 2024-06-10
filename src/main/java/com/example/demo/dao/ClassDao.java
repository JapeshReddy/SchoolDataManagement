package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Class;

public interface ClassDao {

	Class saveClass(Class c);

	Class updateClass(Class c);

	boolean deleteClassByID(int id);

	Class getClassByID(int id);

	List<Class> getAllClassDetailsByYear(int year);


	boolean existsClassByYear(int year);

	void updateBoysCountByOne(Class clas, boolean increment);

	void updateGirlsCountByOne(Class clas, boolean increment);


	boolean checkIfIdExists(int id);

	void updateSectionsCountByOne(Class clas, boolean increment);

}
