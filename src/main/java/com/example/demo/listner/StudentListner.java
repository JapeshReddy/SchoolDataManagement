package com.example.demo.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.ContextHelper;
import com.example.demo.dao.ClassDao;
import com.example.demo.dao.SectionDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Section;
import com.example.demo.entity.Student;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

@Component
public class StudentListner {

	private boolean setDao = true;

	@Autowired
	private ClassDao c_dao;

	@Autowired
	private SectionDao s_dao;

	public void setDao() {
		ApplicationContext context = ContextHelper.getContext();

		if (setDao) {
			c_dao = context.getBean(ClassDao.class);
			s_dao = context.getBean(SectionDao.class);
			setDao = false;
		}

	}

	@PrePersist
	public void incremantStudentsByOne(Student student) {
		char gender = student.getGender();
		setDao();
		boolean b = true;
		Section sec = student.getSection_ref();
		Class clas = sec.getClass_ref();
		if (gender == 'm' || gender == 'M') {
			s_dao.updateBoysCountByOne(sec, b);
			c_dao.updateBoysCountByOne(clas, b);
		} else {
			s_dao.updateGirlsCountByOne(sec, b);
			c_dao.updateGirlsCountByOne(clas, b);
		}
	}

	@PreRemove
	public void decremantStudentssByOne(Student student) {
		char gender = student.getGender();
		setDao();
		boolean b = false;
		Section sec = student.getSection_ref();
		Class clas = sec.getClass_ref();
		if (gender == 'm' || gender == 'M') {
			s_dao.updateBoysCountByOne(sec, b);
			c_dao.updateBoysCountByOne(clas, b);
		} else {
			s_dao.updateGirlsCountByOne(sec, b);
			c_dao.updateGirlsCountByOne(clas, b);
		}
	}
}
