package com.example.demo.serviceImplemantation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClassDao;
import com.example.demo.dto.ClassDto;
import com.example.demo.entity.Class;
import com.example.demo.service.ClassService;

import jakarta.transaction.Transactional;

@Service
public class ClassServiceImplementation implements ClassService {

	@Autowired
	private ClassDao dao;

	@Override
	@Transactional
	public ClassDto saveClass(Class c) {
		Class _class = dao.saveClass(c);
		ClassDto dto = getDTO(_class);

		return dto;
	}

	@Override
	@Transactional
	public ClassDto updateClass(Class c, int id) {

		c.setId(id);
		Class _class = dao.updateClass(c);

		ClassDto dto = getDTO(_class);
		return dto;
	}

	@Override
	@Transactional
	public boolean deleteClassByID(int id) {
		return dao.deleteClassByID(id);
	}

	@Override
	public ClassDto getClassByID(int id) {
		Class _class = dao.getClassByID(id);
		ClassDto dto = getDTO(_class);
		return dto;

	}

	@Override
	public List<ClassDto> getAllClassDetailsByYear(int year) {
		List<Class> list = dao.getAllClassDetailsByYear(year);
		
		
		ArrayList<ClassDto> dtoList = new ArrayList<>();
		list.forEach((_class) -> {
			ClassDto dto = getDTO(_class);
			dtoList.add(dto);
		});
		
		return dtoList.stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).toList();
	}

	private static ClassDto getDTO(Class _class) {
		ClassDto dto = new ClassDto();
		dto.setId(_class.getId());
		dto.setName(_class.getName());
		dto.setBoysCount(_class.getBoysCount());
		dto.setGirlsCount(_class.getGirlsCount());
		dto.setSectionCount(_class.getSectionsCount());
		dto.setAcademicYear(_class.getAcademicYear());

		return dto;
	}

}
