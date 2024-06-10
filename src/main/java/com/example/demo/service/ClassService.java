package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.ClassDto;
import com.example.demo.entity.Class;
public interface ClassService {

	ClassDto saveClass(Class c);

	ClassDto updateClass(Class c,int id);

	boolean deleteClassByID(int id);

	ClassDto getClassByID(int id);

	List<ClassDto> getAllClassDetailsByYear(int year);
}
