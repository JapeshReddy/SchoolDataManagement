package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;

public interface SubjectRepositry extends JpaRepository<Subject, Integer> {

}
