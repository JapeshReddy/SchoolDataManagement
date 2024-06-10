package com.example.demo.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.ContextHelper;
import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Section;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

@Component
public class SectionListener {

	@Autowired
	private ClassDao c_dao;

	public void setc_dao() {
		if (c_dao == null) {
			ApplicationContext context = ContextHelper.getContext();
			c_dao = context.getBean(ClassDao.class);
		}
	}

	@PrePersist
	public void updateSectionCount(Section sec) {
		setc_dao();
		c_dao.updateSectionsCountByOne(sec.getClass_ref(), true);

	}

	@PreRemove
	public void deleteSectionCount(Section sec) {
		setc_dao();
		c_dao.updateSectionsCountByOne(sec.getClass_ref(), false);
	}
}
