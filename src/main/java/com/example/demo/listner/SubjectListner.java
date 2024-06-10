package com.example.demo.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.ContextHelper;
import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Subject;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

@Component
public class SubjectListner {

	@Autowired
	private ClassDao c_dao;

	public void setDao() {
		if (c_dao == null) {
			ApplicationContext context = ContextHelper.getContext();
			c_dao = context.getBean(ClassDao.class);
		}
	}

	@PrePersist
	public void incremeantSectionsCount(Subject subject) {
		setDao();
		c_dao.updateSectionsCountByOne(subject.getClass_ref(), true);
	}

	@PreRemove
	public void decremeantSectionsCount(Subject subject) {
		setDao();
		c_dao.updateSectionsCountByOne(subject.getClass_ref(), false);
	}

}
