package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface ClassRepositry extends JpaRepository<Class, Integer> {

}
